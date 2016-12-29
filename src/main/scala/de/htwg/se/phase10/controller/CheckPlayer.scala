//package de.htwg.se.phase10.controller
//import de.htwg.se.phase10.model.impl.PlayerList.playerList
//import de.htwg.se.phase10.model.impl._
//import scala.collection.mutable.ListBuffer
//
//object CheckPlayer {
//  def checkAnzPlayer(anz : Int) : Boolean ={
//    if (anz >= 2 && anz <= 4) return true
//    return false
//  }
//  
//  def createPlayer(name:String) : Boolean = {
//    for (x<-playerList) {
//      if (x.name.equals(name)) return false
//    }
//    playerList += new Player(name)
//    return true;
//  }
//  
//  def getPlayerList() : String = {
//    var s =""
//    for (x <- playerList ) {
//      s+= " | " + x 
//    }
//    return s + " | "
//  } 
//  
//  def getPlayer() : ListBuffer[String] = {
//    var getPlayerList = new ListBuffer[String]()
//    for (x <- playerList) {
//      getPlayerList += x.toString()
//    }
//    return getPlayerList
//  }
//  
//  def checkPlayerOption(input:Int) : Boolean = {
//    if (input >= 1 && input <= 3) return true
//    return false
//  }
//
//  def givePlayerHandCards(){
//    for (x <- playerList) x.createHand()
//  }
//
//  def getHandCards(name:String) : String = {
//    var handAsString = ""
//    for (x <- playerList)  if (x.name.equals(name)) handAsString = x.hand.mkString(", ")
//    return handAsString;
//  }
//  
//  def checkBreak(name:String) : Boolean = {
//    for (x<-playerList) if(name.equals(x.name) && x.break) return true
//    return false
//  }
//  
//  def setBreak(name:String) {
//    for (x<-playerList) if(name.equals(x.name)) x.break = !x.break
//  }
//  
//  def getStopPlayerList(name : String) : String = {
//    var s =""
//    var i = 0
//    for (x <- playerList ) {
//        i += 1
//        s+= "("+i+") " + x +"\n"
//    }
//    return s
//  }
//  
//  def checkPlayerStop(i : Int) : Boolean = {
//    if (i >= 1 && i <= getPlayer.size) {
//      var name = getPlayer()(i-1); 
//      for (x <- playerList) {
//        if(name.equals(x.name) && !x.break) {
//          x.break = true
//          return true
//        }
//      }
//    }
//    return false
//  }
//  
//  def getHandSize(name:String) : Int = {
//    var i = 0;
//    for (x <- playerList) if(x.name.equals(name)) i = x.hand.size
//    return i
//  }
//  
//  def putCardStack(name:String, i:Int) {
//    for (x <- playerList) {
//        if(name.equals(x.name)) {
//          x.dropToStack(x.hand(i-1))
//        }
//    }
//  }
//  
//  def getPhase(name:String) : (String,Int) = {
//    var ret = ("",0)
//    for (x <- playerList) {
//        if(name.equals(x.name)) {
//          x.checkPhase match {
//            case 1 => ret = ("2 Drillinge",6)
//            case 2 => ret = ("1 Drilling + 1 Viererfolge",7)
//            case 3 => ret = ("1 Vierling + 1 Viererfolge",8)
//            case 4 => ret = ("1 Siebenerfolge",7)
//            case 5 => ret = ("1 Achterfolge",8)
//            case 6 => ret = ("1 Neunerfolge",9)
//            case 7 => ret = ("2 Vierlinge",8)
//            case 8 => ret = ("7 Karten einer Farbe",7)
//            case 9 => ret = ("1 Fünfling + 1 Zwilling",7)
//            case 10 => ret = ("1 Fünfling + 1 Drilling",8)
//          }
//        }
//    }
//    return ret
//  }
//  
//  def addToMoveList(name:String,i:Int) {
//    for (x <- playerList) {
//        if(name.equals(x.name)) {
//          var card = x.hand(i-1)
//          x.hand -= card
//          x.addCard(card)
//        }
//    }
//  }
//  
//  def getPhaseInt(name:String) : Int = {
//    var i = 1; 
//    for (x <- playerList) {
//        if(name.equals(x.name)) {
//          i = x.checkPhase
//        }
//     }
//    return i
//  }
//  
//  def playerFinishedRound(name:String) : Boolean = {
//     for (x <- playerList) {
//        if(name.equals(x.name) && x.hand.size == 0) {
//          return true
//        }
//     }
//    return false
//  }
//  
//  def changePlayerList() {
//    var one = playerList.take(1)
//    playerList = playerList.drop(1)
//    playerList :+ one
//  }
//  
//  def getMoveList(name:String) : String = {
//    var s = ""
//    for(x <- playerList) {
//      if (x.name.equals(name)) {
//        for(y <- x.moveList) {
//          s += " | " + y 
//        }
//      }
//    }
//    return s + " | "
//  }
//  
//    def movePhase(name:String) {
//    for(x <- playerList) {
//      if (x.name.equals(name)) 
//        x.move()
//    }
//  }
//  
//  def getMoved(name:String) : Boolean = {
//    var ret = false
//    for(x <- playerList) {
//      if (x.name.equals(name)) 
//        ret = x.moved
//    }
//    return ret
//  }
//  
//  def updateHand(name:String) {
//    for(x <- playerList) {
//      if (x.name.equals(name)) { 
//        x.hand ++= x.moveList
//        x.moveList.clear()
//      }
//    }
//  }
//  
//  def movedPhase() : String = {
//    var s = ""
//    for (x <- playerList)
//      s += x.moveList.mkString(", \n")
//    return s + "hier"
//  }
//}