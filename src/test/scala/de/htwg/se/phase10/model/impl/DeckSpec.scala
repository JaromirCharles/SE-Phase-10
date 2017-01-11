package de.htwg.se.phase10.model.impl

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class DeckSpec extends WordSpec {
  
  "A Deck when created" should {
    Deck.createShuffleDeck
    "should not be Nil" in {
      Deck.cards should not be(Nil) 
    }
    "have a size" in {
      Deck.getDeckSize should be(108)
    }
  }
  
  "A Deck setIcons" should {
    Deck.setIcons()
    "have an icon" in {
      for (card <- Deck.cards)
        card.getIcon should not be(null)
    }
  }
  
  "A Deck when recreating from stack" should {
    Deck.createShuffleDeck
    "have a Decksize" in {
      Stack.stack = Deck.cards
      Deck.createDeckFromStack()
      Deck.getDeckSize should be(107)
    }
  }
}