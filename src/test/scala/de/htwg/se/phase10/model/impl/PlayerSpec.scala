package de.htwg.se.phase10.model.impl

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PlayerSpec extends WordSpec {
  
  "A Player" should {
    var stack = new Stack()
    var deck = new Deck()
    val player = new Player("Jaromir", deck , stack)
    
    "have a name" in {
      player.name should be ("Jaromir")
    }
    
    "have a toString representation" in {
      player.toString() should be("Jaromir")
    }
    
    "should not have a moved Variable" in {
      player.moved should be(false)
    }
    
    "should have a phase" in {
      player.phase should be(Phase1)
    }
    
    "should have a checkPhase" in {
      player.checkPhase should be(1)
    }
    
    "should not have a hand" in {
      player.hand should be(Nil)
    }
    
    "should not have a moveList" in {
      player.moveList should be(Nil)
    }
    
    "should not have a break" in {
      player.checkBreak should be(false)
    }
    
    "should not have a pulled card" in {
      player.pulledCard should be(false)
    }
    
    "should have a Phase length" in {
      player.getPhaseLength() should be(3)
    }
  }
  
  "A player" should {
    var stack = new Stack()
    var deck = new Deck()
    val player2 = new Player("Maxi",deck,stack)
    
    "have an empty hand" in {
      player2.hand should be(Nil)
    }
    
    "have a hand after creating it" in {
     deck.createShuffleDeck
     stack.createStack(deck)
      player2.createHand()
      player2.hand should not be(Nil)
    }
    
    "have 10 hand cards" in {
      player2.handSize should be(10)
    }
    
    "be stopped" in {
      player2.setBreak
      player2.checkBreak should be(true)
    }
    
    "should be in the next state" in {
      player2.setState(Phase2)
      player2.phase should be(Phase2)
    }
    
    "be in the next phase" in {
      player2.setPhase()
      player2.checkPhase should be(2)
    }
    
    "have a new phase length" in {
      player2.setPhaseLength(7)
      player2.getPhaseLength() should be(7)
    }
    
    "takes a card from deck" in {
      var firstCardDeck = deck.cards.head
      player2.takeFromDeck() should be(firstCardDeck)
      player2.handSize should be(11)
      player2.pulledCard should be(true)
    }
    
    "dropes to stack" in {
      val dropCard = player2.hand(10)
      player2.dropToStack(player2.hand(10)) should be(dropCard)
      player2.handSize should be(10)
      player2.pulledCard should be(false)
      stack.stack.head should be(dropCard)
    }
    
    "takes a card from stack" in {
      var firstCardstack = stack.stack.head
      player2.takeFromStack() should be(firstCardstack)
      player2.handSize should be(11)
      player2.pulledCard should be(true)
    }
  }
  
  "A player" should {
    var stack = new Stack()
    var deck = new Deck()
    val player3 = new Player("Nico", deck ,stack)
    val player4 = new Player("Artur", deck ,stack)
    "can add a card to move List" in {
      player3.addCard(NormalCard(Colors.Green,10))
      player3.addCard(NormalCard(Colors.Yellow,10))
      player3.addCard(SpecialCard(CardType.Joker))
      player3.addCard(SpecialCard(CardType.Joker))
      player3.addCard(NormalCard(Colors.Red,9))
      player3.addCard(NormalCard(Colors.Purple,9))
      player3.moveList.size should be(6)
      
      player4.addCard(NormalCard(Colors.Green,11))
      player4.addCard(NormalCard(Colors.Yellow,10))
      player4.addCard(SpecialCard(CardType.Joker))
      player4.addCard(SpecialCard(CardType.Joker))
      player4.addCard(NormalCard(Colors.Red,9))
      player4.addCard(NormalCard(Colors.Purple,9))
      player4.moveList.size should be(6)
    }
    
    "can move his move list" in {
      player3.move()
      player3.moved should be(true)
      
      player4.move()
      player4.moved should be(false)
    }
    
    "can be stopped" in {
      player3.setBreak
      player3.checkBreak should be(true)
    }
    
    "can play again" in {
      player3.setBreak
      player3.checkBreak should be(false)
    }
  }
}
