package de.htwg.se.phase10.model

trait iPlayer {
  def move(moveCards:List[Card])
  def takeFromDeck(card:List[Card]) : String
  def takeFromStack(card:List[Card]) : String
  def dropToStack(card:Card)
}