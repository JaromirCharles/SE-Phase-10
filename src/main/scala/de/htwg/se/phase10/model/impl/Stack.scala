package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.model.IStack

object Stack extends IStack {
  var stack:List[Card] = Nil
  
  def createStack() {
    stack = Deck.cards.take(1)
    Deck.cards = Deck.cards.drop(1)
  }
  
  def stackSize = stack.size
  
  def getTopCard() = stack.head
}