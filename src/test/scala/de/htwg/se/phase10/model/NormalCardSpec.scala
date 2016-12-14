package de.htwg.se.phase10.model

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
    }
  }
  "A normal Card" should {
    val normalCard  = NormalCard(Colors.Purple, 10)
    "hava  a type" in {
      normalCard.cardtype should be(10)
    }
  }

}
