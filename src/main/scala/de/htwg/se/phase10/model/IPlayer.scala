package de.htwg.se.phase10.model

import de.htwg.se.phase10.model.impl.Card
import de.htwg.se.phase10.model.impl.Phase

trait IPlayer {
  
  //moves his phase 
  def move
  
  //set the break value to true/false
  def setBreak
  
  //gives Player 10 hand cards
  def createHand
  
  //returns break value
  def checkBreak : Boolean
  
  //returns the number of elements of the hand
  def handSize : Int
  
  //takes first Card from Deck and put it to hand
  def takeFromDeck : Card
  
  //takes first Card from Stack and put it to hand
  def takeFromStack : Card
  
  //drops a Card from hand to stack
  def dropToStack(card:Card) : Card
  
  //set the state
  def setState(p:Phase)

  //set the phase
  def setPhase()
  
  //add a card to moveList
  def addCard(card: Card)
}