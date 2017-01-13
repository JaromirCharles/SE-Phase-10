package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.controller.impl.Controller
import scala.collection.mutable.ListBuffer

object CardWorksheet {
	var controller = new Controller           //> controller  : de.htwg.se.phase10.controller.impl.Controller = de.htwg.se.pha
                                                  //| se10.controller.impl.Controller@531be3c5
	controller.createPlayer("jaromir")
	controller.createPlayer("maxi")
	controller.givePlayerHandCards()
	println(controller.playerList.playerList) //> ListBuffer(jaromir, maxi)
	for (player <- controller.playerList.playerList) {
		println(player.hand)              //> ListBuffer()
                                                  //| ListBuffer()
	}
}