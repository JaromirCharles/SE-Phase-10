package de.htwg.se.phase10.model


trait IStack {
  
  //create a new Stack
  def createStack(deck:IDeck)
  
  //returns a list from cards
  def allExceptFirst() : List[ICard]
  
  //returns the size of the stack
  def stackSize : Int
  
  //remove all excepts first card
  def removeAllExceptFirst()
  
  //remove Card from stack
  def removeCard(number:Int)
  
  //returns the first card of the stack
  def getTopCard : ICard
  
  //add to stack
  def addToStack(card:ICard)
  
}