package de.htwg.se.phase10.controller

import de.htwg.se.phase10.model.impl.Player
import de.htwg.se.phase10.model.ICard
import scala.collection.mutable.ListBuffer
import de.htwg.se.phase10.model.impl.Card
import de.htwg.se.phase10.util.Observer.IObservable

trait IController extends IObservable{

  //starts new game
  def newGame(bool:Boolean)

  //checks if new game has started
  def checkNewGame() : Boolean

  //quits the game
  def quitGame()

  //returns the number of all Player
  def getNumberAllPlayer : Int

  //sets the number of all Player
  def setNumberAllPlayer(number:Int)

  //returns the status of the game 
  def getStatus() : GameStatus.Value

  //creates the Deck and the Stack
  def createStackDeck() 

  //returns the first Card of the Stack
  def getStack() : String

  //returns size of the stack
  def getStackSize() : Int

  //returns first card of the stack as type card to set icons
  def getStackCard() : ICard

  //returns the player from name
  def getPlayer(name:String) : Player

  //Creates a new Player and adds him\her to the playerList
  def createPlayer(name:String)

  //returns name of player
  def getName() : String

  // returns a player
  def getPlayer() : Player

  //returns all Players as String
  def getPlayerList() : String

  //gives every Player 10 hand cards
  def givePlayerHandCards()

  //returns the Player which is in his turn
  def getPlayerTurn() : ListBuffer[String]

  //get Hand of the player
  def getHand() : String

  //returns the moveList of every player 
  def getMoveList() : String

  //returns the moveList of the player moving the phase
  def getPlayerMoveList() : String

  //adds a card to move list
  def addToMoveList(index:Int)

  //moves the phase
  def movePhase()

  //checks if the player already did the phase 
  def getMove() : Boolean

  //returns size of hand
  def getHandSize() : Int

  //gives the player his card if the phase failed
  def updateHand()

  //sets the playerNumber 
  def setPlayerNumber()

  //returns playerNumber
  def getPlayerNumber() : Int

  //gets a Card from the Deck
  def getCardDeck() : String

  //gets a Card from the Stack
  def getCardStack() : String

  //puts a Card from his hand to the stack
  def dropCardStack(index:Int) : String

  //returns the name of the phase and the number of cards he needs as tuple
  def getPhaseNameNumber() : (String,Int)

  //Checks if a player is already stopped returns true if he is stopped false if not
  def stopPlayer(index:Int)

  //checks if player already pulled a card
  def getPullCard() : Boolean

  //gets the next player
  def skipPlayer(name:String)

  //checks if player is stopped
  def getBreak(name:String) : Boolean

  //stops a player if he is not stopped yet
  def setBreak(name:String)

  //checks if player has break card and removes it 
  def checkRemoveBreak() : Boolean

  //set Phase at the end of the round
  def setNextPhase()

  //checks if Player finished Round
  def finishedRound() : Boolean

  //checks if Player finished Game
  def finishedGame() : Boolean

  //start a new Round
  def startNewRound()

  //get Variable Round
  def getRoundOver() : Boolean

  //checks if game is over
  def getGameOver() : Boolean

  def addCardToList(indexSpieler:Int,indexCard:Int,indexWo:Int) : Boolean

  def checkAdd(player:Player) : Boolean
}