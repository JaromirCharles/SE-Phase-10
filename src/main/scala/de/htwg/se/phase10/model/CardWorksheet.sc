package de.htwg.se.phase10.model
import scala.collection.mutable.ListBuffer

object CardWorksheet {
  1 + 2 + 1                                       //> res0: Int = 4
  val c = new NormalCard(Colors.Green, 7)         //> c  : de.htwg.se.phase10.model.NormalCard = NormalCard(Green,7)
  c.color                                         //> res1: de.htwg.se.phase10.model.Colors.Value = Green
  c.cardtype                                      //> res2: Int = 7

var list = List(new SpecialCard(CardType.Joker),new SpecialCard(CardType.Joker),new NormalCard(Colors.Red, 7),new NormalCard(Colors.Red, 8),new NormalCard(Colors.Red, 8),new NormalCard(Colors.Red, 9),new NormalCard(Colors.Red, 10),new NormalCard(Colors.Red, 8))
                                                  //> list  : List[Product with Serializable with de.htwg.se.phase10.model.Card] =
                                                  //|  List(SpecialCard(Joker), SpecialCard(Joker), NormalCard(Red,7), NormalCard(
                                                  //| Red,8), NormalCard(Red,8), NormalCard(Red,9), NormalCard(Red,10), NormalCard
                                                  //| (Red,8))
          print("Hallo")                          //> Hallo
  list.length                                     //> res3: Int = 8
  list.head                                       //> res4: Product with Serializable with de.htwg.se.phase10.model.Card = Special
                                                  //| Card(Joker)
  val smallerlist = list.tail                     //> smallerlist  : List[Product with Serializable with de.htwg.se.phase10.model.
                                                  //| Card] = List(SpecialCard(Joker), NormalCard(Red,7), NormalCard(Red,8), Norma
                                                  //| lCard(Red,8), NormalCard(Red,9), NormalCard(Red,10), NormalCard(Red,8))
  val range = 1 to 3                              //> range  : scala.collection.immutable.Range.Inclusive = Range(1, 2, 3)
  range.map(i => NormalCard(Colors.Red, i))       //> res5: scala.collection.immutable.IndexedSeq[de.htwg.se.phase10.model.NormalC
                                                  //| ard] = Vector(NormalCard(Red,1), NormalCard(Red,2), NormalCard(Red,3))
  val kart = new NormalCard(Colors.Red, 7)        //> kart  : de.htwg.se.phase10.model.NormalCard = NormalCard(Red,7)
  print(kart.cardtype)                            //> 7
  
  Deck.cards.size                                 //> res6: Int = 108
	
	val player1 = new Player("Hans")          //> player1  : de.htwg.se.phase10.model.Player = Hans
	player1.hand                              //> res7: scala.collection.mutable.ListBuffer[de.htwg.se.phase10.model.Card] = L
                                                  //| istBuffer(NormalCard(Yellow,6), NormalCard(Green,12), NormalCard(Purple,6), 
                                                  //| NormalCard(Red,9), NormalCard(Purple,4), NormalCard(Purple,9), NormalCard(Re
                                                  //| d,2), NormalCard(Purple,10), NormalCard(Yellow,11), NormalCard(Yellow,9))
  player1.takeFromDeck(Deck.cards)                //> res8: String = NormalCard(Green,4)
  player1.hand                                    //> res9: scala.collection.mutable.ListBuffer[de.htwg.se.phase10.model.Card] = L
                                                  //| istBuffer(NormalCard(Yellow,6), NormalCard(Green,12), NormalCard(Purple,6), 
                                                  //| NormalCard(Red,9), NormalCard(Purple,4), NormalCard(Purple,9), NormalCard(Re
                                                  //| d,2), NormalCard(Purple,10), NormalCard(Yellow,11), NormalCard(Yellow,9), No
                                                  //| rmalCard(Green,4))
  player1.dropToStack(NormalCard(Colors.Purple,5))
  Deck.cards.size                                 //> res10: Int = 96
	Phase4.movePhase(list)                    //> res11: (Boolean, List[Int]) = (true,List(0, 0, 7, 8, 8, 8, 9, 10))
  val player2 = new Player("Peter")               //> player2  : de.htwg.se.phase10.model.Player = Peter
  player2.hand                                    //> res12: scala.collection.mutable.ListBuffer[de.htwg.se.phase10.model.Card] = 
                                                  //| ListBuffer(NormalCard(Red,3), NormalCard(Green,1), NormalCard(Yellow,8), Nor
                                                  //| malCard(Purple,7), NormalCard(Green,7), NormalCard(Purple,11), NormalCard(Pu
                                                  //| rple,11), NormalCard(Red,4), NormalCard(Yellow,4), NormalCard(Yellow,12))
	//val m = collection.mutable.HashMap(new NormalCard(Colors.Blue,5) -> 3,new NormalCard(Colors.Red,7) -> 1,new NormalCard(Colors.Blue,5) -> 3, new NormalCard(Colors.Red,7) -> 1,new NormalCard(Colors.Blue,5) ->1)
	//Phase1.movePhase(m)
    
	Deck.cards.size                           //> res13: Int = 86
	Stack.stack                               //> res14: List[de.htwg.se.phase10.model.Card] = List(NormalCard(Purple,5), Spe
                                                  //| cialCard(Break))
 	Stack.stack = Stack.stack.take(1)
 	Stack.stack                               //> res15: List[de.htwg.se.phase10.model.Card] = List(NormalCard(Purple,5))
	Deck.cards.size                           //> res16: Int = 86

	var x = List(1,2,3,4)                     //> x  : List[Int] = List(1, 2, 3, 4)
	x.filter {_==2 }                          //> res17: List[Int] = List(2)
}