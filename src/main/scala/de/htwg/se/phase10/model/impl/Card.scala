package de.htwg.se.phase10.model.impl
import de.htwg.se.phase10.model.ICard

trait Card extends ICard 

case class NormalCard(color: Colors.Value, cardtype: Int) extends Card {
  def getRank() = this.cardtype
  def getColor() = this.color
  override def toString: String =  getColor().toString() +" "+getRank().toString() 
}

case class SpecialCard(typeCard: CardType.Value) extends Card {
  def getRank() = this.typeCard
  override def toString: String = getRank().toString()
}

object Colors extends Enumeration {
  val Red, Green, Yellow, Purple = Value
}

object CardType extends Enumeration {
  val Joker, Break = Value
}

