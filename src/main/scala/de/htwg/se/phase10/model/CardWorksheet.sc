package de.htwg.se.phase10.model
import scala.collection.mutable.ListBuffer

object CardWorksheet {

	var list = new ListBuffer[Integer]        //> list  : scala.collection.mutable.ListBuffer[Integer] = ListBuffer()
	list += 1 += 2                            //> res0: scala.collection.mutable.ListBuffer[Integer] = ListBuffer(1, 2)
	var i = 1                                 //> i  : Int = 1
	list((i-1))                               //> res1: Integer = 1
  1 + 2 + 1                                       //> res2: Int = 4
  val c = new NormalCard(Colors.Green, 7)         //> c  : de.htwg.se.phase10.model.NormalCard = NormalCard(Green,7)
  c.color                                         //> res3: de.htwg.se.phase10.model.Colors.Value = Green
  c.cardtype                                      //> res4: Int = 7


  val range = 1 to 3                              //> range  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3)
  range.map(i => NormalCard(Colors.Red, i))       //> res5: scala.collection.immutable.IndexedSeq[de.htwg.se.phase10.model.NormalC
                                                  //| ard] = Vector(NormalCard(Red,1), NormalCard(Red,2), NormalCard(Red,3))
  val kart = new NormalCard(Colors.Red, 7)        //> kart  : de.htwg.se.phase10.model.NormalCard = NormalCard(Red,7)
  print(kart.cardtype)                            //> 7
  
  Deck.cards.size                                 //> res6: Int = 0
	
	val player1 = new Player("Hans")          //> player1  : de.htwg.se.phase10.model.Player = Hans
	player1.hand                              //> res7: scala.collection.mutable.ListBuffer[de.htwg.se.phase10.model.Card] = L
                                                  //| istBuffer()
  player1.takeFromDeck(Deck.cards)                //> res8: String = ""
  player1.hand                                    //> res9: scala.collection.mutable.ListBuffer[de.htwg.se.phase10.model.Card] = L
                                                  //| istBuffer()
  player1.dropToStack(NormalCard(Colors.Purple,5))
  Deck.cards.size                                 //> res10: Int = 0
  val player2 = new Player("Peter")               //> player2  : de.htwg.se.phase10.model.Player = Peter
  player2.hand                                    //> res11: scala.collection.mutable.ListBuffer[de.htwg.se.phase10.model.Card] = 
                                                  //| ListBuffer()
	//val m = collection.mutable.HashMap(new NormalCard(Colors.Blue,5) -> 3,new NormalCard(Colors.Red,7) -> 1,new NormalCard(Colors.Blue,5) -> 3, new NormalCard(Colors.Red,7) -> 1,new NormalCard(Colors.Blue,5) ->1)
	//Phase1.movePhase(m)
    
	Deck.cards.size                           //> res12: Int = 0
	Stack.stack                               //> res13: List[de.htwg.se.phase10.model.Card] = List(NormalCard(Purple,5))
 	Stack.stack = Stack.stack.take(1)
 	Stack.stack                               //> res14: List[de.htwg.se.phase10.model.Card] = List(NormalCard(Purple,5))
	Deck.cards.size                           //> res15: Int = 0


  player2.hand                                    //> res16: scala.collection.mutable.ListBuffer[de.htwg.se.phase10.model.Card] = 
                                                  //| ListBuffer()
	//val m = collection.mutable.HashMap(new NormalCard(Colors.Blue,5) -> 3,new NormalCard(Colors.Red,7) -> 1,new NormalCard(Colors.Blue,5) -> 3, new NormalCard(Colors.Red,7) -> 1,new NormalCard(Colors.Blue,5) ->1)
	//Phase1.movePhase(m)
    
	Deck.cards.size                           //> res17: Int = 0
	Stack.stack                               //> res18: List[de.htwg.se.phase10.model.Card] = List(NormalCard(Purple,5))
 	Stack.stack = Stack.stack.take(1)
 	Stack.stack                               //> res19: List[de.htwg.se.phase10.model.Card] = List(NormalCard(Purple,5))
	Deck.cards.size                           //> res20: Int = 0
}