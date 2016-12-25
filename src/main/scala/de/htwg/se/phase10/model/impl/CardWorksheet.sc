package de.htwg.se.phase10.model
import scala.collection.mutable.ListBuffer

object CardWorksheet {
	var normal = new NormalCard(Colors.Green, 10)
                                                  //> normal  : de.htwg.se.phase10.model.NormalCard = NormalCard(Green,10)
	if(normal.getRank().equals(CardType.Break)) {
		println("hier")
	} else {
		println("hier2")
	}                                         //> hier2
}