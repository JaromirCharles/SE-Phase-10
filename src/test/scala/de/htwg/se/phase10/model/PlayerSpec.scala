package de.htwg.se.phase10.model

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PlayerSpec extends WordSpec with Matchers {
  "A Player" should {
    val player = new Player("Jaromir")
    "have a name" in {
      player.name should be ("Jaromir")
    }
    "have a toString representation" in {
      assert(player.toString === "Jaromir")
    }
  }
  "It" should {
    val player = new Player("Jaromir")
    player.phase = Phase1
    player.break = false
    "have a phase" in {
      player.phase = (Phase1)
    }
    "have a start break value" in {
      player.break should be (false)
    }
  }  
}
