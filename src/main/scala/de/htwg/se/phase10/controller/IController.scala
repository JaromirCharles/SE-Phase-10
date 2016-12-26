package de.htwg.se.phase10.controller

import de.htwg.se.phase10.model.impl.Player
import scala.collection.mutable.ListBuffer
import de.htwg.se.phase10.util.Observer.IObservable

trait IController extends IObservable{
  
  //starts new game
  def newGame()
  
  //quits the game
  def quitGame()
  
  //creates Deck and Stack
  def createStackDeck() 
  
  //returns first Card of the Stack
  def getStack() : String
  
  //Number of Player 
  def checkNumberPlayer(number : Int) : Boolean
  
  //Create a new Player and adds him\her to playerList
  def createPlayer(name:String) : Boolean
  
  //returns all Players as String
  def getPlayerList() : String
  
  //gives every Player 10 hand cards
  def givePlayerHandCards()
  
  //returns the Player which is in his turn
  def getPlayerTurn() : ListBuffer[String]
  
  //get Hand of the player
  def getHand(name:String) : String
  
  //returns the moveList of every player 
  def getMoveList() : String
  
  //returns the moveList of the player moving the phase
  def getPlayerMoveList(name:String) : String
  
  //adds a card to moveList
  def addToMoveList(name:String, index:Int)
  
  //moves the phase
  def movePhase(name:String)
  
  //checks if the player did the phase already 
  def getMove(name:String) : Boolean
  
  //gives the player his card if the phase failed
  def updateHand(name:String)
  
  //gets a Card from the Deck
  def getCardDeck(name:String) : String
  
  //gets a Card from the Stack
  def getCardStack(name:String) : String
  
  //puts a Card from his hand to the stack
  def dropCardStack(name:String, index:Int) 
  
  //returns the name of the phase and the number of cards he needs as tuple
  def getPhaseNameNumber(name:String) : (String,Int)
  
  //Checks if a player is already stopped returns true if he is stopped false if not
  def checkPlayerStopped(index:Int) : Boolean
  
  //checks if player is stopped
  def getBreak(name:String) : Boolean
  
  //stops a player if he is not stopped yet
  def setBreak(name:String)
  
  //set Phase at the end of the round
  def setNextPhase()
  
  //checks if Player finished Round
  def finishedRound(name:String) : Boolean
  
  //checks if Player finished Game
  def finishedGame(name:String) : Boolean
  
  //start a new Round
  def startNewRound()
  
  //get Variable Round
  def getRoundOver() : Boolean
  
}