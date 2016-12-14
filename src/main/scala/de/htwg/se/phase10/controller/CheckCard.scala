package de.htwg.se.phase10.controller
import de.htwg.se.phase10.model.Stack
import de.htwg.se.phase10.model.Deck
import de.htwg.se.phase10.model.PlayerList

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
    for (x<- PlayerList.playerList) {
      if (x.name.equals(name) && i == 1) { 
        if (Deck.cards == 0) {
          Deck.cards = Stack.stack.drop(1)
          Stack.stack = Stack.stack.take(1)
        }
        ret = x.takeFromDeck(Deck.cards)
      } else if (x.name.equals(name) && i ==2 && Stack.stack.size > 0) ret = x.takeFromStack(Stack.stack)
      else if (x.name.equals(name) && i ==2 && Stack.stack.size == 0) ret = "Ablagestapel ist gerade leer, daher muss vom Deck gezogen werden!" + x.takeFromDeck(Deck.cards)
    }
    return ret
  }
}