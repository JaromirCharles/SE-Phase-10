package de.htwg.se.phase10.model

trait IPlayer {

  //moves his phase 
  def move

  // get length of phase
  def getPhaseLength() : Int

  // set length of phase
  def setPhaseLength(length:Int)

  //set the break value to true/false
  def setBreak

  //gives Player 10 hand cards
  def createHand

  //returns break value
  def checkBreak : Boolean

  //returns the number of elements in the hand
  def handSize : Int

  //takes first Card from Deck and puts it to hand
  def takeFromDeck : ICard

  //takes first Card from Stack and puts it to hand
  def takeFromStack : ICard

  //drops a Card from hand to stack
  def dropToStack(card:ICard) : ICard

  //set the state
  def setState(p:de.htwg.se.phase10.model.impl.Phase)

  //set the phase
  def setPhase()

  //adds a card to moveList
  def addCard(card: ICard)
}