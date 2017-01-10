package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.model.ICard
import de.htwg.se.phase10.model.IStack

object Stack extends IStack {
  var stack:List[ICard] = Nil
  
  override def createStack() {
    stack = Deck.cards.take(1)
    Deck.cards = Deck.cards.drop(1)
  }
  
  override def stackSize = stack.size
  
  override def getTopCard = stack.head
}