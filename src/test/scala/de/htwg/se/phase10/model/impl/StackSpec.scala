package de.htwg.se.phase10.model.impl

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StackSpec extends WordSpec {
  
  "A Stack when created" should {
    Deck.createShuffleDeck
    var firstCard = Deck.cards.head
    Stack.createStack()
    "should not be Nil" in {
      Stack.stack should not be(Nil)
    }
    "have a size" in {
      Stack.stackSize should be(1)
    }
    "have a first card" in {
      Stack.getTopCard should be(firstCard)
    }
  }
}