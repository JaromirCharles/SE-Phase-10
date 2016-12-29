package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.controller.impl.Controller
import scala.collection.mutable.ListBuffer

object CardWorksheet {

	var normal = NormalCard(Colors.Green, 10) //> normal  : de.htwg.se.phase10.model.impl.NormalCard = Green 10
  var specialBreak = SpecialCard(CardType.Break)  //> specialBreak  : de.htwg.se.phase10.model.impl.SpecialCard = Blau Break
  
  checkRank(normal)                               //> Ist keine Break Karte
  checkRank(specialBreak)                         //> Ist eine Break Karte
  println(specialBreak.getRank)                   //> Break
  def checkRank(card:Card) {
		if(card.getRank.equals(CardType.Break)) {
			println("Ist eine Break Karte")
		} else {
			println("Ist keine Break Karte")
		}
	}                                         //> checkRank: (card: de.htwg.se.phase10.model.impl.Card)Unit
		checkColor(normal)                //> Normal Card
	checkColor(specialBreak)                  //> Special Card
	def checkColor(card:Card) {
		if(card.getColor.equals("Blau")) {
			println("Special Card")
		} else {
			println("Normal Card")
		}
	}                                         //> checkColor: (card: de.htwg.se.phase10.model.impl.Card)Unit
	normal.getRank                            //> res0: Int = 10
	specialBreak.getRank                      //> res1: de.htwg.se.phase10.model.impl.CardType.Value = Break
var strig = "33"                                  //> strig  : String = 33
strig.substring(1).equals("3")                    //> res2: Boolean = true
strig.length()                                    //> res3: Int = 2

var contr = new Controller()                      //> contr  : de.htwg.se.phase10.controller.impl.Controller = de.htwg.se.phase10.
                                                  //| controller.impl.Controller@4de8b406
var index = 2                                     //> index  : Int = 2
contr.createPlayer("horst")
contr.createPlayer("helmut")
contr.getPlayerTurn()(index - 1)                  //> res4: String = helmut
contr.setBreak(contr.getPlayerTurn()(1))
contr.getBreak(contr.getPlayerTurn()(index-1))    //> res5: Boolean = true

var list = new ListBuffer[Int]()                  //> list  : scala.collection.mutable.ListBuffer[Int] = ListBuffer()
list += 5                                         //> res6: scala.collection.mutable.ListBuffer[Int] = ListBuffer(5)
list(0) = 3
list.insert(0, 2)
list                                              //> res7: scala.collection.mutable.ListBuffer[Int] = ListBuffer(2, 3)
list.remove(0)                                    //> res8: Int = 2
list                                              //> res9: scala.collection.mutable.ListBuffer[Int] = ListBuffer(3)
list += 1                                         //> res10: scala.collection.mutable.ListBuffer[Int] = ListBuffer(3, 1)
list += 10                                        //> res11: scala.collection.mutable.ListBuffer[Int] = ListBuffer(3, 1, 10)
list.remove(list.size-1)                          //> res12: Int = 10
list                                              //> res13: scala.collection.mutable.ListBuffer[Int] = ListBuffer(3, 1)
}