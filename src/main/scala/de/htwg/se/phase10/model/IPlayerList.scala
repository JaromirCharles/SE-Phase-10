package de.htwg.se.phase10.model

import scala.collection.mutable.ListBuffer
import de.htwg.se.phase10.model.impl.Player

trait IPlayerList {
  
  def getPlayerList : ListBuffer[Player]
  def addPlayerList(player:Player)
  
}