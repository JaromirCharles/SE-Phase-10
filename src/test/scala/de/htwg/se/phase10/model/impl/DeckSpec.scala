package de.htwg.se.phase10.model.impl

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DeckSpec extends WordSpec {
  var deck = new Deck()
  deck.createShuffleDeck
  "A Deck when created" should {
    "should not be Nil" in {
      deck.cards should not be(Nil) 
    }
    "have a size" in {
      deck.getDeckSize should be(108)
    }
  }
  
  "A Deck setIcons" should {
    deck.setIcons()
    "have an icon" in {
      for (card <- deck.cards)
        card.getIcon should not be(null)
    }
  }
  
  "A Deck when recreating from stack" should {
    var deck2 = new Deck()
    deck2.createShuffleDeck
    var stack = new Stack()
    stack.createStack(deck2)
    "have a Decksize" in {
      stack.stack = deck.cards
      deck.createDeckFromStack(stack)
      deck.getDeckSize should be(107)
    }
  }
}