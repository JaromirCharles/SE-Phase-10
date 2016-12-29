package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.model.IDeck

object Deck extends IDeck {
  private val colors = Array(Colors.Red, Colors.Green, Colors.Yellow, Colors.Purple)
  private val typ = 1 to 12
  private val normalCards = (1 to 2).flatMap(loop => colors.flatMap(color => (typ.map(i => NormalCard(color, i))))).toList

  private val jokerCards = (1 to 8).toList.map(cardindex => SpecialCard(CardType.Joker))
  private val breakCards = (1 to 4).toList.map(cardindex => SpecialCard(CardType.Break))
  
  var cards:List[Card] = Nil
  
  override def createShuffleDeck = cards = scala.util.Random.shuffle(normalCards ::: jokerCards ::: breakCards)
  
  override def getDeckSize = cards.length
  
  override def createDeckFromStack() {
    cards = Stack.stack.drop(1)
    cards = scala.util.Random.shuffle(Deck.cards)
    Stack.stack = Stack.stack.take(1)
  }
}

