package de.htwg.se.phase10.model

object Deck extends iDeck{
  private val colors = Array(Colors.Red, Colors.Green, Colors.Yellow, Colors.Purple)
  private val typ = 1 to 12
  private val normalCards = (1 to 2).flatMap(loop => colors.flatMap(color => (typ.map(i => NormalCard(color, i))))).toList

  private val jokerCards = (1 to 8).toList.map(cardindex => SpecialCard(CardType.Joker))
  private val breakCards = (1 to 4).toList.map(cardindex => SpecialCard(CardType.Break))
  var cards:List[Card] = Nil
  
  def createShuffleDeck() {
    cards = scala.util.Random.shuffle(normalCards ::: jokerCards ::: breakCards)
  }
}

