package de.htwg.se.phase10.model

import javax.swing.ImageIcon
import de.htwg.se.phase10.model.impl.Colors

trait ICard {

  //set the Icon
  def setIcon()

  //returns the icon of the card
  def getIcon : ImageIcon

  //returns the rank of the card
  def getRank : Any

  //returns the color of the card  
  def getColor : String
}