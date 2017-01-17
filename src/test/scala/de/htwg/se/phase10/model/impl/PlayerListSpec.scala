package de.htwg.se.phase10.model.impl;

import de.htwg.se.phase10.controller.impl.Controller
import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.collection.mutable.ListBuffer
import de.htwg.se.phase10.model._

@RunWith(classOf[JUnitRunner])
class PlayerListSpec extends WordSpec {
  
  "Some playerList" should {
    var playerList = new ListBuffer[Player]()
    "have a size" in {
      playerList.size  should be(0)
    }
  }
  
  "A playerList" should {
    var deck:IDeck = new Deck
    var stack:Stack = new Stack()
    var playerList:IPlayerList = new PlayerList()
    var controller = new Controller(deck, stack:IStack, playerList)
    controller.createPlayer("Jaromir")
    controller.createPlayer("Maxi")
    "have a size" in {
      playerList.getPlayerList.size should be (2)
    }
    "have two players" in {
      playerList.getPlayerList(0).name should be ("Jaromir")
      playerList.getPlayerList(1).name should be ("Maxi")
    }
    "not be empty" in {
      playerList.getPlayerList.isEmpty should be (false)
    }
  }
}

