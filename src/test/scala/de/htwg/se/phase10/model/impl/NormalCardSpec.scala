package de.htwg.se.phase10.model.impl

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NormalCardSpec extends WordSpec {

  "A normal Card" should {
    val normalCard = NormalCard(Colors.Red, 9)
    "have a color" in {
      normalCard.color should be(Colors.Red)
      normalCard.getColor should be(Colors.Red.toString())
    }
  }
  
  "A normal Card" should {
    val normalCard  = NormalCard(Colors.Purple, 10)
    "hava  a type" in {
      normalCard.cardtype should be(10)
      normalCard.getRank should be(10)
    }
  }
  
  "A normal Card" should {
    val normalCard = NormalCard(Colors.Green, 11)
    "have an icon" in {
      normalCard.setIcon()
      normalCard.getIcon should not be(null)
    }
    "have a toString" in {
      normalCard.toString() should be("Green 11")
    }
  }
}
