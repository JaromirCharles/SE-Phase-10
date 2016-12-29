package de.htwg.se.phase10.model

import de.htwg.se.phase10.model.impl.Colors

trait ICard {
  
  //returns the rank of the card
  def getRank : Any
  
  //returns the color of the card  
  def getColor : String

}