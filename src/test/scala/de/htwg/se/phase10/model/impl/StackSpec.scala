package de.htwg.se.phase10.model.impl

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class StackSpec extends WordSpec {

  var deck = new Deck()
  deck.createShuffleDeck
  var stack = new Stack()
  var firstCard = deck.getDeck(1).head
  stack.createStack(deck)
  "A Stack when created" should {
    "should not be Nil" in {
      stack.stack should not be(Nil)
    }
    "have a size" in {
      stack.stackSize should be(1)
    }
    "have a first card" in {
      stack.getTopCard should be(firstCard)
    }
  }
}