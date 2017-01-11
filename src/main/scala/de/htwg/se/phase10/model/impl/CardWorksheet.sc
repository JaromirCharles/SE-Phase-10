package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.model.impl.Stack
import de.htwg.se.phase10.controller.impl.Controller
import scala.collection.mutable.ListBuffer

object CardWorksheet {
	var normal = NormalCard(Colors.Green, 10) //> normal  : de.htwg.se.phase10.model.impl.NormalCard = Green 10
  var specialBreak = SpecialCard(CardType.Break)  //> specialBreak  : de.htwg.se.phase10.model.impl.SpecialCard = Blau Break
  var normal2 = NormalCard(Colors.Yellow,20)      //> normal2  : de.htwg.se.phase10.model.impl.NormalCard = Yellow 20
  normal.setIcon()
  normal.getIcon                                  //> res0: javax.swing.ImageIcon = javax.swing.ImageIcon@3f49dace
  
  specialBreak.setIcon()
  specialBreak.getIcon                            //> res1: javax.swing.ImageIcon = javax.swing.ImageIcon@490ab905
  
  normal2.setIcon()
  normal2.getIcon                                 //> res2: javax.swing.ImageIcon = javax.swing.ImageIcon@27c20538
  
  normal.getIcon                                  //> res3: javax.swing.ImageIcon = javax.swing.ImageIcon@3f49dace
  
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
	normal.getRank                            //> res4: Int = 10
	specialBreak.getRank                      //> res5: de.htwg.se.phase10.model.impl.CardType.Value = Break
var strig = "33"                                  //> strig  : String = 33
strig.substring(1).equals("3")                    //> res6: Boolean = true
strig.length()                                    //> res7: Int = 2

var contr = new Controller()                      //> contr  : de.htwg.se.phase10.controller.impl.Controller = de.htwg.se.phase10
                                                  //| .controller.impl.Controller@4566e5bd
var index = 2                                     //> index  : Int = 2
contr.createPlayer("horst")
contr.createPlayer("helmut")
contr.getPlayerTurn()(index - 1)                  //> res8: String = helmut
contr.setBreak(contr.getPlayerTurn()(1))
contr.getBreak(contr.getPlayerTurn()(index-1))    //> res9: Boolean = true

var list = new ListBuffer[Int]()                  //> list  : scala.collection.mutable.ListBuffer[Int] = ListBuffer()
list += 5                                         //> res10: scala.collection.mutable.ListBuffer[Int] = ListBuffer(5)
list(0) = 3
list.insert(0, 2)
list                                              //> res11: scala.collection.mutable.ListBuffer[Int] = ListBuffer(2, 3)
list.remove(0)                                    //> res12: Int = 2
list                                              //> res13: scala.collection.mutable.ListBuffer[Int] = ListBuffer(3)
list += 1                                         //> res14: scala.collection.mutable.ListBuffer[Int] = ListBuffer(3, 1)
list += 10                                        //> res15: scala.collection.mutable.ListBuffer[Int] = ListBuffer(3, 1, 10)
list.remove(list.size-1)                          //> res16: Int = 10
Deck.createShuffleDeck
Deck.getDeckSize                                  //> res17: Int = 108
Stack.stack = Deck.cards
Stack.stackSize                                   //> res18: Int = 108
Deck.createDeckFromStack()
Deck.getDeckSize                                  //> res19: Int = 107

var player = new Player("Maxi")                   //> player  : de.htwg.se.phase10.model.impl.Player = Maxi
player.createHand()
player.handSize                                   //> res20: Int = 10
player.hand.equals(Nil)                           //> res21: Boolean = false|
}