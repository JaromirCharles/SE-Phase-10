package de.htwg.se.phase10.model
import scala.collection.mutable.ListBuffer

object CardWorksheet {
	var liste:ListBuffer[Card] =new ListBuffer[Card]()
                                                  //> liste  : scala.collection.mutable.ListBuffer[de.htwg.se.phase10.model.Card] 
                                                  //| = ListBuffer()
	liste.append(new SpecialCard(CardType.Joker))
	liste.append(new SpecialCard(CardType.Joker))
	liste.append(new NormalCard(Colors.Red,9))
	liste.append(new SpecialCard(CardType.Joker))
	liste.append(new SpecialCard(CardType.Joker))
	liste.append(new NormalCard(Colors.Red,10))
  
	val x = new Player("x")                   //> x  : de.htwg.se.phase10.model.Player = x
		x.moveList = liste
		x.move()                          //> java.lang.IndexOutOfBoundsException: 6
                                                  //| 	at scala.collection.LinearSeqOptimized$class.apply(LinearSeqOptimized.sc
                                                  //| ala:65)
                                                  //| 	at scala.collection.immutable.List.apply(List.scala:84)
                                                  //| 	at de.htwg.se.phase10.model.helperMethods$.checkJoker(Phasen.scala:87)
                                                  //| 	at de.htwg.se.phase10.model.helperMethods$.checkTwoGroups(Phasen.scala:1
                                                  //| 5)
                                                  //| 	at de.htwg.se.phase10.model.Phase1$.checkPhaseSize(Phasen.scala:96)
                                                  //| 	at de.htwg.se.phase10.model.Player.move(Player.scala:26)
                                                  //| 	at de.htwg.se.phase10.model.CardWorksheet$$anonfun$main$1.apply$mcV$sp(d
                                                  //| e.htwg.se.phase10.model.CardWorksheet.scala:15)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at de.htwg.se.phase10
                                                  //| Output exceeds cutoff limit.
	
}