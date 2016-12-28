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
  private var break = false
  var pulledCard = false
  var phaseLength = 0

  def createHand() {
     hand.clear()
     val handHelp = Deck.cards.take(10)
     for(x <- handHelp) hand += x
     Deck.cards = Deck.cards.drop(10)
  }
  
  override def checkBreak = break
  
  override def setBreak = break = !break
  
  override def handSize = hand.size
  
  override def setState(p:Phase) = this.phase = p
  
  override def setPhase() = this.checkPhase += 1
  
  override def addCard(card: Card) = moveList.append(card)
  
  override def move() = if (phase.checkPhaseSize(moveList.toList))  moved = true

  override def takeFromDeck() : Card = {
    val drawnCard = Deck.cards.head
    Deck.cards = Deck.cards.drop(1)
    hand += drawnCard
    pulledCard = true
    return drawnCard
  }
  
  override def takeFromStack() : Card = {
    val drawnCard = Stack.stack.head
    hand += drawnCard
    Stack.stack = Stack.stack.drop(1)
    pulledCard = true
    return drawnCard
  }
  
  override def dropToStack(card:Card) : Card = {
    hand -= card
    Stack.stack = Stack.stack.::(card)
    pulledCard = false
    card
  }
  
  override def toString: String =  name
}
 

