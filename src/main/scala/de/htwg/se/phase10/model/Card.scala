package de.htwg.se.phase10.model

trait Card
case class NormalCard(color: Colors.Value, cardtype: Int) extends Card

case class SpecialCard(typeCard: CardType.Value) extends Card

object Colors extends Enumeration {
  val Red, Green, Yellow, Purple = Value
}

object CardType extends Enumeration {
  val Joker, Break = Value
}

