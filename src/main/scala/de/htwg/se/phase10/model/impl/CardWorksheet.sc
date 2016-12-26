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
	
	var con = new Controller()                //> con  : de.htwg.se.phase10.controller.impl.Controller = de.htwg.se.phase10.co
                                                  //| ntroller.impl.Controller@5afa04c
	con.createPlayer("maxi")                  //> res2: Boolean = true
	con.createPlayer("jaromir")               //> res3: Boolean = true
	con.createPlayer("maxi")                  //> res4: Boolean = false
 	
 	con.createStackDeck()
 	con.givePlayerHandCards()
 	con.getHand("maxi")                       //> res5: String = "(1) Red 11
                                                  //| (2) Green 1
                                                  //| (3) Green 5
                                                  //| (4) Purple 5
                                                  //| (5) Yellow 7
                                                  //| (6) Blau Break
                                                  //| (7) Purple 1
                                                  //| (8) Blau Joker
                                                  //| (9) Green 9
                                                  //| (10) Purple 7
                                                  //| "
con.getBreak("jaromir")                           //> res6: Boolean = false
con.setBreak("jaromir")
con.getBreak("jaromir")                           //> res7: Boolean = true

con.finishedRound("maxi")                         //> res8: Boolean = false
}