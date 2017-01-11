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
      PlayerList.playerList.size should be (2)
    }
    "have two players" in {
      PlayerList.playerList(0).name should be ("Jaromir")
      PlayerList.playerList(1).name should be ("Maxi")
    }
    "not be empty" in {
      PlayerList.playerList.isEmpty should be (false)
    }
  }
}

