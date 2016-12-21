package de.htwg.se.phase10.model
import scala.collection.mutable.ListBuffer

object CardWorksheet {
	var liste = List(new SpecialCard(CardType.Joker),new SpecialCard(CardType.Joker),new NormalCard(Colors.Red,9),new NormalCard(Colors.Red,10),new NormalCard(Colors.Red,10),new NormalCard(Colors.Red,10))
                                                  //> liste  : List[Product with Serializable with de.htwg.se.phase10.model.Card] 
                                                  //| = List(SpecialCard(Joker), SpecialCard(Joker), NormalCard(Red,9), NormalCard
                                                  //| (Red,10), NormalCard(Red,10), NormalCard(Red,10))
	val x = new Player("x")                   //> x  : de.htwg.se.phase10.model.Player = x
	x.move(liste)                             //> true
}