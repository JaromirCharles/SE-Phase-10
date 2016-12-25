package de.htwg.se.phase10.model.impl
import de.htwg.se.phase10.model.IPlayer
import scala.collection.mutable.ListBuffer

class Player(playerName: String) extends IPlayer {
  val name = playerName
  var moved = false
  var phase : Phase = Phase1
  var checkPhase = 1
  var hand = new ListBuffer[Card]()
  var moveList = new ListBuffer[Card]()
  var break = false

  def createHand() {
     hand.clear()
     val handHelp = Deck.cards.take(10)
     for(x <- handHelp) hand += x
     Deck.cards = Deck.cards.drop(10)
  }
  
  def handSize = hand.size
  
  def setState(p:Phase) = this.phase = p
  
  def addCard(card: Card) = moveList.append(card)
  
  def move() = if (phase.checkPhaseSize(moveList.toList))  moved = true

  def takeFromDeck() : Card = {
    val drawnCard = Deck.cards.head
    Deck.cards = Deck.cards.drop(1)
    hand += drawnCard
    return drawnCard
  }
  
  def takeFromStack() : Card = {
    val drawnCard = Stack.stack.head
    hand += drawnCard
    Stack.stack = Stack.stack.drop(1)
    return drawnCard
  }
  
  def dropToStack(card:Card) {
    hand -= card
    Stack.stack = Stack.stack.::(card)
  }
  
  override def toString: String =  name
}
 

