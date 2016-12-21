package de.htwg.se.phase10.model

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class scala extends WordSpec {
  "A Deck when created" should {
    var myDeck = Deck.cards
    "have a size" in {
      myDeck.size should be (108)
    }
  }
  "A Deck" when {
    "empty" should {
      "have a value of" {
        myDeck.isEmpty should be (True)
      }
    }
  }
  "A Deck" should {
    var myDeck2 = Deck.cards
    val myHand = Deck.cards.take(1)
    myDeck2 = myDeck2.drop(1)
    "when a card is removed have a size" in {
      myDeck2.size == myDeck2.size - 1
    }
  }
}