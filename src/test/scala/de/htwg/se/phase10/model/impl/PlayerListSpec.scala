package de.htwg.se.phase10.model.impl;

import de.htwg.se.phase10.controller.impl.Controller
import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.collection.mutable.ListBuffer

@RunWith(classOf[JUnitRunner])
class PlayerListSpec extends WordSpec {
  
  "A playerList" should {
    var controller = new Controller()
    controller.createPlayer("Jaromir")
    controller.createPlayer("Maxi")
    "have a size" in {
      controller.playerList.playerList.size should be (2)
    }
    "have two players" in {
      controller.playerList.playerList(0).name should be ("Jaromir")
      controller.playerList.playerList(1).name should be ("Maxi")
    }
    "not be empty" in {
      controller.playerList.playerList.isEmpty should be (false)
    }
  }
}

