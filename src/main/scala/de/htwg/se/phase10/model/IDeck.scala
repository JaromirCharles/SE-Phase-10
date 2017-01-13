package de.htwg.se.phase10.model

import de.htwg.se.phase10.model.impl.Card

trait IDeck {
  
  //creates and shuffles deck
  def createShuffleDeck
  
  //returns size of the deck
  def getDeckSize : Int
  
  //creates a new deck when old deck is empty  
  def createDeckFromStack(stack:IStack)
  
  //remove cards from Deck
  def dropDeck(number : Int)
  
  //returns list from Cards
  def getDeck(number:Int) : List[ICard]
  
  //set all Icons in cards
  def setIcons()
}