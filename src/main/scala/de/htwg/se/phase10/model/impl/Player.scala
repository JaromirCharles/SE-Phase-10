package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.model.ICard
import de.htwg.se.phase10.model.IDeck
import de.htwg.se.phase10.model.IStack
import de.htwg.se.phase10.model.IPlayer
import scala.collection.mutable.ListBuffer

class Player(playerName: String, deck: IDeck, stack:IStack) extends IPlayer {
  val name = playerName
  var moved = false
  var phase : Phase = Phase1
  var checkPhase = 1
  var hand = new ListBuffer[ICard]()
  var moveList = new ListBuffer[ICard]()
  private var break = false
  var pulledCard = false
  private var phaseLength = 3

  def createHand() {
     hand.clear()
     val handHelp = deck.getDeck(10)
     for(card <- handHelp) hand += card
     deck.dropDeck(10)
  }

  override def getPhaseLength() = phaseLength

  override def setPhaseLength(length:Int) = phaseLength = length

  override def checkBreak = break

  override def setBreak = break = !break

  override def handSize = hand.size

  override def setState(p:de.htwg.se.phase10.model.impl.Phase) =this.phase = p

  override def setPhase() = this.checkPhase += 1

  override def addCard(card: ICard) = moveList.append(card)

  override def move() = if (phase.checkPhaseSize(moveList.toList))  moved = true

  override def takeFromDeck() : ICard = {
    val drawnCard = deck.getDeck(1).head
    deck.dropDeck(1)
    hand += drawnCard
    pulledCard = true
    return drawnCard
  }

  override def takeFromStack() : ICard = {
    val drawnCard = stack.getTopCard
    hand += drawnCard
    stack.removeCard(1)
    pulledCard = true
    return drawnCard
  }

  override def dropToStack(card:ICard) : ICard = {
    hand -= card
    stack.addToStack(card)
    pulledCard = false
    card
  }

  override def toString: String =  name
}