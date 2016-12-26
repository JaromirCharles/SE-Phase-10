package de.htwg.se.phase10.controller.impl

import de.htwg.se.phase10.model.impl.Deck
import de.htwg.se.phase10.model.impl.Card
import de.htwg.se.phase10.model.impl.Stack
import de.htwg.se.phase10.model.impl.Player
import de.htwg.se.phase10.model.impl._
import de.htwg.se.phase10.model.impl.PlayerList.playerList
import de.htwg.se.phase10.controller.GameStatus
import de.htwg.se.phase10.controller.ExitGameEvent
import de.htwg.se.phase10.controller.UpdateStack
import de.htwg.se.phase10.controller.StartGame
import de.htwg.se.phase10.controller.AddPlayer
import de.htwg.se.phase10.controller.IController
import scala.collection.mutable.ListBuffer
import de.htwg.se.phase10.util.Observer.Observable
import de.htwg.se.phase10.model.impl.Phase2

class Controller extends Observable with IController {
  
  private var roundOver = false
  private var gameOver = false
  private var gameStatus = GameStatus.Welcome
  
  override def newGame() {
    notifyObservers(new StartGame())
    createStackDeck()
    gameStatus = GameStatus.NewGame
  }
  
  override def quitGame() {
    notifyObservers(new ExitGameEvent())
    gameStatus = GameStatus.ExitGame
  }
  
  override def createStackDeck() {
    Deck.createShuffleDeck
    gameStatus = GameStatus.NewDeck
    Stack.createStack()
    gameStatus = GameStatus.NewStack
  }
  
  override def getStack() = Stack.getTopCard().toString()
  
  override def checkNumberPlayer(number:Int) = if (number >= 2 && number <= 4) true else false
  
  override def createPlayer(name:String) : Boolean = {
    for (x <- playerList) if (x.name.equals(name)) return false
    playerList += new Player(name) 
    gameStatus = GameStatus.AddPlayer
    notifyObservers(new AddPlayer())
    return true
  }
 
  override def getPlayerTurn() : ListBuffer[String] = {
    var getPlayerList = new ListBuffer[String]()
    for (x <- playerList) {
      getPlayerList += x.toString()
    }
    return getPlayerList
  }
  
  override def getPlayerList() : String = {
    var returnString =""
    var index = 0
    for (player <- playerList ) {
      index += 1
      returnString += "("+index+") " + player +("\n")
    }
    returnString
  }
  
  override def givePlayerHandCards() = for (player <- playerList) player.createHand()
  
  override def getHand(name:String) : String = {
    var returnString = ""
    var index = 0
    for (player <- playerList) if (player.name.equals(name)) {
      for (card <- player.hand) {
        index += 1
        returnString += "("+index+") " + card + "\n"
      }
    }
    returnString
  }
  
  override def getPhaseNameNumber(name:String) : (String,Int) = {
    var returnTuple = ("",0)
    for (player <- playerList) {
      if(name.equals(player.name)) {
        player.checkPhase match {
            case 1 => returnTuple = ("2 Drillinge",6)
            case 2 => returnTuple = ("1 Drilling + 1 Viererfolge",7)
            case 3 => returnTuple = ("1 Vierling + 1 Viererfolge",8)
            case 4 => returnTuple = ("1 Siebenerfolge",7)
            case 5 => returnTuple = ("1 Achterfolge",8)
            case 6 => returnTuple = ("1 Neunerfolge",9)
            case 7 => returnTuple = ("2 Vierlinge",8)
            case 8 => returnTuple = ("7 Karten einer Farbe",7)
            case 9 => returnTuple = ("1 Fünfling + 1 Zwilling",7)
            case 10 => returnTuple = ("1 Fünfling + 1 Drilling",8)
          }
        }
    }
    return returnTuple
  }
  
  override def getMoveList() : String = {
    var returnString = ""
    for (player <- playerList) returnString += player.name + ": " + player.moveList.mkString(" ,\n")
    returnString
  }
  
  override def getPlayerMoveList(name:String) : String = {
    var returnString = ""
    for (player <- playerList) {
      if (player.name.equals(name)) {
        for(card <- player.moveList) returnString += " | " + card 
      }
    }
    returnString
  }
  
  override def addToMoveList(name:String, index:Int) {
    for (player <- playerList) {
      if(name.equals(player.name)) {
        var card = player.hand(index-1)
        player.hand -= card
        player.addCard(card)
      }
    }
  }
  
  override def movePhase(name:String) = for (player <- playerList) if(player.name.equals(name)) player.move
    
  override def getMove(name:String) : Boolean = {
    for (player <- playerList) 
      if(player.name.equals(name) && player.moved) return true 
    false
  }
  
  override def updateHand(name:String) {
    for(player <- playerList) {
      if (player.name.equals(name))  player.hand ++= player.moveList
    }
  }
  
  override def getCardDeck(name:String) : String = {
    var returnCard = ""
    for (player <- playerList) {
      if (player.name.equals(name)) { 
        if (Deck.getDeckSize == 0) 
          Deck.createDeckFromStack()
      returnCard = player.takeFromDeck().toString()
      }
    }
    notifyObservers
    returnCard
  }
  
  override def getCardStack(name:String) : String = {
    var returnCard = ""
    for (player <- playerList) {
      if (player.name.equals(name)) { 
        if (Stack.stackSize == 0) returnCard = player.takeFromDeck().toString()
        else {
          notifyObservers(new UpdateStack())
          returnCard = player.takeFromStack().toString()
        }
      }
    }
    returnCard
  }
  
  override def dropCardStack(name:String, index:Int) {
    for (player <- playerList) if(name.equals(player.name)) player.dropToStack(player.hand(index-1))
    notifyObservers(new UpdateStack())
    if (finishedRound(name)) roundOver = true
    if (finishedGame(name)) gameOver = true
  }
  
  override def getBreak(name:String) : Boolean = {
    for (player <- playerList) if (player.name.equals(name) && player.checkBreak) return true 
    return false
  }
  
  override def checkPlayerStopped(index:Int) : Boolean = {
    if (getBreak(getPlayerTurn()(index-1))) return true
    setBreak(getPlayerTurn()(index-1))
    false
  }
  
  override def setBreak(name:String) =  for (player <- playerList) if (player.name.equals(name)) player.setBreak
  
  override def finishedRound(name:String) : Boolean = {
    for (player <- playerList) if (player.name.equals(name) && player.handSize != 0 && player.checkPhase != 10) return false 
    gameStatus = GameStatus.RoundOver
    return false
  }
  
  override def finishedGame(name:String) : Boolean = {
    for (player <- playerList) if (player.name.equals(name) && player.handSize != 0 && player.checkPhase == 10) return false 
    gameStatus = GameStatus.GameOver
    return false
  }
  
  override def setNextPhase() {
     for (player <- playerList) {
       player.checkPhase match {
         case 1 => player.setPhase(); player.setState(Phase2);
         case 2 => player.setPhase(); player.setState(Phase3);
         case 3 => player.setPhase(); player.setState(Phase4);
         case 4 => player.setPhase(); player.setState(Phase5);
         case 5 => player.setPhase(); player.setState(Phase6);
         case 6 => player.setPhase(); player.setState(Phase7);
         case 7 => player.setPhase(); player.setState(Phase8);
         case 8 => player.setPhase(); player.setState(Phase9);
         case 9 => player.setPhase(); player.setState(Phase10);
       }
     }
  }
  
  override def getRoundOver() = roundOver
  
  override def startNewRound() {
    //rotate PlayerList
    var firstPlayer = playerList.take(1)
    playerList = playerList.drop(1)
    playerList :+ firstPlayer
    //shuffle Deck again give Player Handcards and create new Stack
    createStackDeck()
    givePlayerHandCards()
    //clear Droplist from every Player
    roundOver = false
    for (player <- playerList) player.moveList.clear()
    gameStatus = GameStatus.NextRound
  }
}