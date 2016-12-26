package de.htwg.se.phase10.controller
import de.htwg.se.phase10.model.impl.Player
import de.htwg.se.phase10.model.impl.PlayerList._
import de.htwg.se.phase10.model.impl.Deck;
import de.htwg.se.phase10.model.impl.Stack;
import de.htwg.se.phase10.model.impl.CardType.Break;
import de.htwg.se.phase10.model.impl.SpecialCard


object CheckCard {
  def getStack() : String = {
    Stack.stack.take(1).mkString
  }
  
  def checkGetCard(i : Int) : Boolean = {
    if (i >= 1 && i <= 2) return true
    return false
  }
  
  def getGetCard(name : String,i : Int) : String = {
    var ret = ""
    for (x<- playerList) {
      if (x.name.equals(name) && i == 1) { 
        if (Deck.cards == 0) {
          Deck.cards = Stack.stack.drop(1)
          Deck.cards = scala.util.Random.shuffle(Deck.cards)
          Stack.stack = Stack.stack.take(1)
        }
        ret = x.takeFromDeck().toString()
      } else if (x.name.equals(name) && i ==2 && Stack.stack.size > 0) ret = x.takeFromStack().toString()

      else if (x.name.equals(name) && i ==2 && Stack.stack.size == 0) ret = "Ablagestapel ist gerade leer, daher muss vom Deck gezogen werden! " + x.takeFromDeck()

    }
    return ret
  }
  
  def createDeckStack() {
    Deck.createShuffleDeck
    Stack.createStack()
  }
  
  def checkBreakCard(name:String) : Boolean = {
    for (x<- playerList) {
      if(name.equals(x.name)) {
        for (y <- x.hand) {
          y match {
            case break:SpecialCard if (break.typeCard.equals(Break)) => x.hand -= break; return true;
            case default =>
          }
        }
      }
    }
    return false;
  }
  
  def getIndexCardList(name:String) : String = {
    var s = ""
    var i = 0
    for(x <- playerList) {
      if (x.name.equals(name)) {
        for(y <- x.hand) {
          i += 1
          s += "("+i+") "+ y +"\n"
        }
      }
    }
    return s
  }
}