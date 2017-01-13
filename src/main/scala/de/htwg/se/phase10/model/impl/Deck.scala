package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.model.ICard
import de.htwg.se.phase10.model.IDeck
import de.htwg.se.phase10.model.IStack

class Deck extends IDeck {
  private val colors = Array(Colors.Red, Colors.Green, Colors.Yellow, Colors.Purple)
  private val typ = 1 to 12
  private val normalCards = (1 to 2).flatMap(loop => colors.flatMap(color => (typ.map(i => NormalCard(color, i))))).toList

  private val jokerCards = (1 to 8).toList.map(cardindex => SpecialCard(CardType.Joker))
  private val breakCards = (1 to 4).toList.map(cardindex => SpecialCard(CardType.Break))
  
  var cards:List[ICard] = Nil
  
  override def createShuffleDeck {
    cards = scala.util.Random.shuffle(normalCards ::: jokerCards ::: breakCards)
    setIcons()
  }
  
  override def setIcons() {
    for (card <- cards) {
      card.setIcon() 
    }
  }
    
  override def getDeckSize = cards.length
  
  override def dropDeck(number : Int) {
    this.cards = cards.drop(number)
  }
  
  override def getDeck(number:Int) = cards.take(number)

  
  override def createDeckFromStack(stack:IStack) {
    cards = stack.allExceptFirst()
    cards = scala.util.Random.shuffle(cards)
    stack.removeAllExceptFirst()
  }
}

