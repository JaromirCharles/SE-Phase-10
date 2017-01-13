package de.htwg.se.phase10.model.impl

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DeckSpec extends WordSpec {
  "A Deck when created" should {
    var deck = new Deck()
    deck.createShuffleDeck
    "should not be Nil" in {
      deck.cards should not be(Nil) 
    }
    "have a size" in {
      deck.getDeckSize should be(108)
    }
    
    "have a size after removing" in {
      deck.dropDeck(108)
      deck.getDeckSize should be(0)
    }
  }
  
  "A Deck setIcons" should {
    var deck = new Deck()
    deck.createShuffleDeck
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
    
    "have a decklist" in {
      deck2.getDeck(1) should be(deck2.cards.take(1))
    }
    
    "have a Decksize" in {
      stack.stack = deck2.cards
      deck2.createDeckFromStack(stack)
      deck2.getDeckSize should be(107)
    }
  }
}