package de.htwg.se.phase10.model

object Stack extends iStack{
  var stack:List[Card] = Nil
  
  def createStack() {
    stack = Deck.cards.take(1)
    Deck.cards = Deck.cards.drop(1)
  }
}