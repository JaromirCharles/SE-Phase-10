package de.htwg.se.phase10.controller.impl

import de.htwg.se.phase10.model.impl.Deck
import de.htwg.se.phase10.model.impl.Card
import de.htwg.se.phase10.model.impl.Stack
import de.htwg.se.phase10.model.impl.Player
import de.htwg.se.phase10.model.impl._
import de.htwg.se.phase10.model.impl.PlayerList.playerList
import de.htwg.se.phase10.controller.GameStatus
import de.htwg.se.phase10.controller.ExitGame
import de.htwg.se.phase10.controller.UpdateStack
import de.htwg.se.phase10.controller.StartGame
import de.htwg.se.phase10.controller.AddPlayer
import de.htwg.se.phase10.controller.IController
import scala.collection.mutable.ListBuffer
import de.htwg.se.phase10.util.Observer.Observable
import de.htwg.se.phase10.model.impl.Phase2
import de.htwg.se.phase10.model.impl.helperMethods

class Controller extends Observable with IController {
  
  private var roundOver = false
  private var gameOver = false
  private var gameStatus = GameStatus.Welcome
  private var newGameValue = false
  private var playerNumber = 0
  private var countPlayer = 0
  private var playerMovedList = 0
  
  override def newGame(bool:Boolean) {
    newGameValue = bool
    if (newGameValue) {
      notifyObservers(new StartGame())
      createStackDeck()
      gameStatus = GameStatus.NewGame
    }
  }
  
  override def checkNewGame() = newGameValue
  
  override def quitGame() {
    notifyObservers(new ExitGame())
    gameStatus = GameStatus.ExitGame
  }
  
  override def getStatus() = gameStatus
  
  override def createStackDeck() {
    Deck.createShuffleDeck
    gameStatus = GameStatus.NewDeck
    Stack.createStack()
    gameStatus = GameStatus.NewStack
    notifyObservers(new UpdateStack())
  }
  
  override def getStack() : String = {
    if (Stack.stackSize == 0) {
      return "---- Empty ----"
    }
    Stack.getTopCard().toString()
  }
  
  override def getStackSize() = Stack.stackSize
  
  override def getStackCard() = Stack.getTopCard()
  
  override def createPlayer(name:String)  {
    playerList += new Player(name)
    countPlayer += 1
    gameStatus = GameStatus.AddPlayer
    notifyObservers(new AddPlayer())
  }
  
  override def getName() = getPlayer().name
  
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
  
  override def getHand() : String = {
    var returnString = ""
    var index = 0
    var player = playerList(this.playerNumber)
    for (card <- player.hand) {
      index += 1
      returnString += "("+index+") " + card + "\n"
    }
    returnString
  }
  
  override def getHandSize() = getPlayer.handSize
  
  override def getPhaseNameNumber() : (String,Int) = {
    var returnTuple = ("",0)
    var player = getPlayer()
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
    return returnTuple
  }
  
  override def getMoveList() : String = {
    var returnString = ""
    for (player <- playerList) {
      if(player.moved) {
        playerMovedList += 1
        returnString += player.name + ": " + player.moveList.mkString(" ,")+"\n"
      }
    }
    if (playerMovedList == 0) {
      return "----- Nobody did this phase ----"
    }
    returnString
  }
  
  override def getPlayerMoveList() : String = {
    var returnString = ""
    for(card <- getPlayer().moveList) returnString += " | " + card 
    returnString
  }
  
  override def addToMoveList(index:Int) {
    var player = playerList(this.playerNumber)
    var card = player.hand(index-1)
    player.hand -= card
    player.addCard(card)
  }
  
  override def movePhase() = getPlayer().move
    
  override def getMove() = getPlayer().moved

  override def updateHand() {
    getPlayer().hand ++= getPlayer().moveList 
    getPlayer().moveList.clear()
  }
  
  override def getPullCard() = getPlayer.pulledCard; notifyObservers
  
  override def getCardDeck() : String = {
    if (Deck.getDeckSize == 0) 
      Deck.createDeckFromStack()
    var returnCard = getPlayer().takeFromDeck().toString()
    notifyObservers
    returnCard
  }
  
  override def getCardStack() : String = {
    var returnCard = ""
    if (Stack.stackSize == 0) 
      returnCard = getPlayer().takeFromDeck().toString()
    else {
     notifyObservers(new UpdateStack())
     returnCard = getPlayer().takeFromStack().toString()
    }
    returnCard
  }
  
  override def dropCardStack(index:Int) : String = {
    var dropCard = getPlayer.dropToStack(getPlayer().hand(index-1)).toString()
    notifyObservers(new UpdateStack())
    if (finishedRound()) roundOver = true
    if (finishedGame()) gameOver = true
    return dropCard
  }
  
  override def getBreak(name:String) : Boolean = {
    for (player <- playerList) {
      if (player.name.equals(name) && player.checkBreak) return true
    }
    false
  }
  
  override def skipPlayer(name:String) {
    for (player <- playerList) {
      if (player.name.equals(name)) {
        player.setBreak
        setPlayerNumber()   
      }
    }
  }
  
  override def stopPlayer(index:Int) = if (!getBreak(getPlayerTurn()(index-1))) setBreak(getPlayerTurn()(index-1))
  
  override def setBreak(name:String) {
    for (player <- playerList) {
      if (player.name.equals(name)) {
        player.setBreak
        getPlayer().pulledCard = false
      }
    }
  }
  
  override def checkRemoveBreak() : Boolean = {
    var player = getPlayer()
    for (card <- player.hand) {
      card match {
        case break:SpecialCard if (break.typeCard.equals(CardType.Break)) => player.hand -= break; return true
        case default =>
      }
    }
    return false
  }
  
  override def finishedRound() : Boolean = {
    if(getPlayer().handSize == 0 && getPlayer().checkPhase != 10) {
      gameStatus = GameStatus.RoundOver
      return true 
    }
    false 
  }
  
  override def finishedGame() : Boolean = {
    if (getPlayer().handSize == 0 && getPlayer().checkPhase == 10) {
      gameStatus = GameStatus.GameOver
      return true 
    }
    false
  }
  
  override def setNextPhase() {
     for (player <- playerList) {
       player.checkPhase match {
         case 1 => if (player.moved) {player.setPhase(); player.setState(Phase2); player.setPhaseLength(3)}
                   else player.setPhaseLength(3) 
         case 2 => if (player.moved) {player.setPhase(); player.setState(Phase3); player.setPhaseLength(4)}
                   else player.setPhaseLength(3) 
         case 3 => if (player.moved) {player.setPhase(); player.setState(Phase4); player.setPhaseLength(7)}
                   else player.setPhaseLength(4)
         case 4 => if (player.moved) {player.setPhase(); player.setState(Phase5); player.setPhaseLength(8)}
                   else player.setPhaseLength(7)
         case 5 => if (player.moved) {player.setPhase(); player.setState(Phase6); player.setPhaseLength(9)}
                   else player.setPhaseLength(8)
         case 6 => if (player.moved) {player.setPhase(); player.setState(Phase7); player.setPhaseLength(4)}
                   else player.setPhaseLength(9)
         case 7 => if (player.moved) {player.setPhase(); player.setState(Phase8); player.setPhaseLength(7)}
                   else player.setPhaseLength(4)
         case 8 => if (player.moved) {player.setPhase(); player.setState(Phase9); player.setPhaseLength(5)}
                   else player.setPhaseLength(7)
         case 9 => if (player.moved) {player.setPhase(); player.setState(Phase10); player.setPhaseLength(5)}
                   else player.setPhaseLength(5)
         case 10 => player.setPhaseLength(5)
       }
     }
  }
  
  override def setPlayerNumber() = if (playerNumber < countPlayer - 1) playerNumber += 1 else playerNumber = 0
  
  override def getPlayerNumber() = this.playerNumber
  
  override def getRoundOver() = roundOver
  
  override def getGameOver() = gameOver
  
  override def getPlayer() = playerList(playerNumber)
  
  override def startNewRound() {
    setNextPhase()
    createStackDeck()
    givePlayerHandCards()
    roundOver = false
    playerMovedList = 0
    for (player <- playerList) {
      player.moveList.clear()
      player.moved = false
    }
    gameStatus = GameStatus.NextRound
  }

  override def addCardToList(indexSpieler:Int,indexCard:Int,indexWo:Int) : Boolean = {
    var handCard = getPlayer.hand(indexCard-1)
    var movePlayer = getPlayerTurn()(indexSpieler - 1)
    for (player <- playerList) {
      if (player.name.equals(movePlayer) && indexWo == 1 && player.moved) {
        player.moveList.insert(0, handCard)
        player.setPhaseLength(player.getPhaseLength() + 1);
        if (!checkAdd(player)) {
          player.moveList.remove(0)
          player.setPhaseLength(player.getPhaseLength() - 1);
          return false
        } else {
          getPlayer.hand -= handCard
          return true
        }
      } else if (player.name.equals(movePlayer) && indexWo == 2 && player.moved) {
        player.moveList.insert(player.getPhaseLength(), handCard)
        if (!checkAdd(player)) {
          player.moveList.remove(player.getPhaseLength())
          player.moveList += handCard
          if (!checkAdd(player)) {
            player.moveList.remove(player.moveList.length-1)
            return false
          } else {
            getPlayer.hand -= handCard
            return true
          }
        } else {
          getPlayer.hand -= handCard
          return true  
        }
      }
    }
    return false
  }
  
  override def checkAdd(player:Player) : Boolean = {
    var length = player.getPhaseLength()
    player.checkPhase match {
      case 1 | 7 | 9 | 10 if (player.moved && helperMethods.checkTwoGroups(player.moveList.toList, player.getPhaseLength())) =>  return true;
      case 2 | 3 | 0  if (player.moved && helperMethods.checkOneGroup(player.moveList.toList, player.getPhaseLength())) => return true;
      case 4 | 5 | 6 if (player.moved && helperMethods.checkRow(player.moveList.toList, player.getPhaseLength())) => return true;
      case 8 if (player.moved && helperMethods.checkColor(player.moveList.toList, player.getPhaseLength())) => return true;
      case default => return false
    }
  }
}