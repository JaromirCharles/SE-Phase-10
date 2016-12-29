package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.model.ICard

trait Card extends ICard 

case class NormalCard(color: Colors.Value, cardtype: Int) extends Card {
  override def getRank = this.cardtype
  override def getColor = this.color.toString()
  override def toString: String =  getColor +" "+getRank.toString() 
}

case class SpecialCard(typeCard: CardType.Value) extends Card {
  override def getRank = this.typeCard
  override def getColor = "Blau"
  override def toString: String = getColor+" "+getRank.toString()
}

object Colors extends Enumeration {
  val Red, Green, Yellow, Purple = Value
}

object CardType extends Enumeration {
  val Joker, Break = Value
}

