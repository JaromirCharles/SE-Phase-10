package de.htwg.se.phase10.model.impl;

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SpecialCardSpec extends WordSpec {
  
  "A special Card" should {
    val specialCardJoker = SpecialCard(CardType.Joker)
    "have a type" in {
      specialCardJoker.typeCard should be(CardType.Joker)
      specialCardJoker.getRank should be(CardType.Joker)
    }
  }
  
  "A special Card" should {
    val specialCard = SpecialCard(CardType.Joker)
    "have a color" in {
      specialCard.getColor should be("Blau")
    }
  }
  
  "A special Card" should {
    val specialCardBreak  = SpecialCard(CardType.Break)
    "hava  a type" in {
      specialCardBreak.typeCard should be(CardType.Break)
    }
  }
  
  "A special Card" should {
    val specialCard = SpecialCard(CardType.Break)
    "have an icon" in {
      specialCard.setIcon()
      specialCard.getIcon should not be(null)
    }
    "have a toString" in {
       specialCard.toString() should be("Blau Break") 
    }
  }
} 