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
  
  def getPhase(nameList : ListBuffer[String]) : Int = {
    var phaseList = new ListBuffer[Int]
    for (x <- nameList) {
      for (y <- playerList) {
        if (x.equals(y.name)) 
          phaseList += y.checkPhase
      }
    }
      return phaseList.max
  }
  
  def checkBreak(name:String) : Boolean = {
    for (x<-playerList) if(name.equals(x.name) && x.break) return true
    return false
  }
  
  def setBreak(name:String) {
    for (x<-playerList) if(name.equals(x.name)) x.break = !x.break
  }
  
  def getStopPlayerList(name : String) : String = {
    var s =""
    var i = 0
    for (x <- playerList ) {
        i += 1
        s+= "("+i+") " + x +"\n"
    }
    return s
  }
  
  def checkPlayerStop(i : Int) : Boolean = {
    if (i >= 1 && i <= getPlayer.size) {
      var name = getPlayer()(i-1); 
      for (x <- playerList) {
        if(name.equals(x.name) && !x.break) {
          x.break = true
          return true
        }
      }
    }
    return false
  }
  
  def getHandSize(name:String) : Int = {
    var i = 0;
    for (x <- playerList) if(x.name.equals(name)) i = x.hand.size
    return i
  }
  
  def putCardStack(name:String, i:Int) {
    for (x <- playerList) {
        if(name.equals(x.name)) {
          x.dropToStack(x.hand(i-1))
        }
    }
  }
}