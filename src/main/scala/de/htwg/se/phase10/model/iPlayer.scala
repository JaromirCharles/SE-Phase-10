package de.htwg.se.phase10.model

trait iPlayer {
  def move()
  def takeFromDeck(card:List[Card]) : String
  def takeFromStack(card:List[Card]) : String
  def dropToStack(card:Card)
}