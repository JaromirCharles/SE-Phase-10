package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.model.IPlayerList
import scala.collection.mutable.ListBuffer

class PlayerList extends IPlayerList {

  var playerList = new ListBuffer[Player]()
  
  override def getPlayerList = playerList
  
  override def addPlayerList(player:Player) = playerList += player
}