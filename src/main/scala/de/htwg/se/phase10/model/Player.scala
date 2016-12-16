package de.htwg.se.phase10.model
import scala.collection.mutable.ListBuffer

class Player(playerName: String) {
  val name:String = playerName
  var phase : Phase = Phase1
  var hand = new ListBuffer[Card]()
  var break = false
  
  def getHandCard() {
     hand.clear()
     val handHelp = Deck.cards.take(10)
     for(x <- handHelp) {hand += x}
     Deck.cards = Deck.cards.drop(10)
  }
  
  private def setState(p:Phase) {
    this.phase = p
  }
  
  def move(moveCards:List[Card]) {
    phase.movePhase(moveCards)
  }

  def takeFromDeck(card:List[Card]) : String = {
    val retString = Deck.cards.take(1).mkString
    val handHelp = card.take(1)
    for (x <- handHelp) {hand += x}
    Deck.cards = Deck.cards.drop(1)
    return retString
  }
  
  def takeFromStack(card:List[Card]) : String = {
    val retString = Stack.stack.take(1).mkString
    val handHelp = card.take(1)
    for (x <- handHelp) {hand += x}
    Stack.stack = Stack.stack.drop(1)
    return retString
  }
  
  def dropToStack(card:Card) {
    hand -= card
    Stack.stack = Stack.stack.::(card)
  }
  
  def breakToPlayer(card:Card, name:Player) {
    name.break = true
    hand -= card
  }
  
  override def toString: String = 
    name
}
 

