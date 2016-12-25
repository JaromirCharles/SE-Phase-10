package de.htwg.se.phase10.model

import de.htwg.se.phase10.model.impl.Card

trait IPlayer {
  def move
  def createHand
  def handSize : Int
  def takeFromDeck : Card
  def takeFromStack : Card
  def dropToStack(card:Card)
}