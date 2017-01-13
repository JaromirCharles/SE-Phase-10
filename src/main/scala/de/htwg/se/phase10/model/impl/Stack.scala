package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.model.ICard
import de.htwg.se.phase10.model.IStack
import de.htwg.se.phase10.model.IDeck

class Stack extends IStack {
  var stack:List[ICard] = Nil
  
  override def createStack(deck:IDeck) {
    this.addToStack(deck.getDeck(1).head)
    deck.dropDeck(1)
  }
  
  override def allExceptFirst() = stack.drop(1)
  
  override def removeCard(number:Int) = stack = stack.drop(number)
  
  override def addToStack(card:ICard) = stack = stack.::(card)
  
  override def removeAllExceptFirst() = stack = stack.take(1)
  
  override def stackSize = stack.size
  
  override def getTopCard = stack.head
}