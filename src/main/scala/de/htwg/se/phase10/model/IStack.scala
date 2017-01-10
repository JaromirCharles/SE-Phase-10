package de.htwg.se.phase10.model


trait IStack {
  
  //create a new Stack
  def createStack
  
  //returns the size of the stack
  def stackSize : Int
  
  //returns the first card of the stack
  def getTopCard : ICard
  
}