package de.htwg.se.phase10.model.impl
import de.htwg.se.phase10.model.IPlayerList
import scala.collection.mutable.ListBuffer

object PlayerList extends IPlayerList {
  var playerList = new ListBuffer[Player]()
}