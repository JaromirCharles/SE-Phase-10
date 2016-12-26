package de.htwg.se.phase10.model

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import de.htwg.se.phase10.modell.CardType;

@RunWith(classOf[JUnitRunner])
class SpecialCardSpec extends WordSpec {
    "A special Card" should {
    val specialCardJoker = SpecialCard(CardType.Joker)
    "have a type" in {
      specialCardJoker.typeCard should be(CardType.Joker)
    }
  }
  "A special Card" should {
    val specialCardBreak  = SpecialCard(CardType.Break)
    "hava  a type" in {
      specialCardBreak.typeCard should be(CardType.Break)
    }
  }
} 