package de.htwg.se.phase10.model.impl

import javax.swing.ImageIcon
import de.htwg.se.phase10.model.ICard

trait Card extends ICard 

case class NormalCard(color: Colors.Value, cardtype: Int) extends Card {
  var icon:ImageIcon = null
  override def getRank = this.cardtype
  override def getColor = this.color.toString()
  override def setIcon() {
    icon = new ImageIcon(new ImageIcon("./img/" + getColor + getRank +".jpg").getImage().getScaledInstance(100,120, java.awt.Image.SCALE_SMOOTH))
  }
  override def getIcon = icon
  override def toString: String =  getColor +" "+getRank.toString() 
}

case class SpecialCard(typeCard: CardType.Value) extends Card {
  var icon:ImageIcon = null
  override def getRank = this.typeCard
  override def getColor = "Blau"
  override def setIcon() {
    icon = new ImageIcon(new ImageIcon("./img/" + getColor + getRank +".jpg").getImage().getScaledInstance(100,120, java.awt.Image.SCALE_SMOOTH))
  }
  override def getIcon = icon 
  override def toString: String = getColor+" "+getRank.toString()
}

object Colors extends Enumeration {
  val Red, Green, Yellow, Purple = Value
}

object CardType extends Enumeration {
  val Joker, Break = Value
}

