package de.htwg.se.phase10.model.impl

import de.htwg.se.phase10.model.ICard
trait Phase {
  //Checks if list has enough elements 
  def checkPhaseSize(cards:List[ICard]) : Boolean
}