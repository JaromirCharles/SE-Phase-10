package de.htwg.se.phase10.controller
import de.htwg.se.phase10.model.PlayerList.playerList
import de.htwg.se.phase10.model.Player
import scala.collection.mutable.ListBuffer

object CheckPlayer {
  
  def checkAnzPlayer(anz : Int) : Boolean ={
    if (anz >= 2 && anz <= 4) return true
    return false
  }
  
  def createPlayer(name:String) : Boolean = {
    for (x<-playerList) {
      if (x.name.equals(name)) return false
    }
    playerList += new Player(name)
    return true;
  }
  
  def getPlayerList() : String = {
    var s =""
    for (x <- playerList ) {
      s+= " | " + x 
    }
    return s + " | "
  } 
  
  def getPlayer() : ListBuffer[String] = {
    var getPlayerList = new ListBuffer[String]()
    for (x <- playerList) {
      getPlayerList += x.toString()
    }
    return getPlayerList
  }
  
  def checkPlayerOption(input:Int) : Boolean = {
    if (input >= 1 && input <= 3) return true
    return false
  }
  
  def givePlayerHandCards(name:String){
    for (x <- playerList) if(x.name.equals(name)) x.getHandCard()
  }
  
  def getHandCards(name:String) : String = {
    var handAsString = ""
    for (x <- playerList)  if (x.name.equals(name)) handAsString = x.hand.mkString(", ")
    return handAsString;
  }
}