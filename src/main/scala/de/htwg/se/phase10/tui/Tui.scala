package de.htwg.se.phase10.tui
import de.htwg.se.phase10.controller.CheckPlayer._
import de.htwg.se.phase10.controller.CheckCard._
import scala.util.control.Breaks._

object helperMethods {
    def numberOfPlayer() : Int = {
    var bool = true
    var anzPlayer = 0
    while (bool) { 
      println("Anzahl der Spieler eingeben (zwischen 2 - 4): ");
      try { anzPlayer = scala.io.StdIn.readInt(); if (!checkAnzPlayer(anzPlayer)) println("Nur Zahlen im Bereich von 2 - 4 eingeben!") else bool = false
      } catch { case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 2 - 4 eingeben!")
      }
    } 
    return anzPlayer;
  }
  
  def nameOfPlayer() {
    var numberPlayer = 1; var anzPlayer = numberOfPlayer(); var i = 1; println("Namen der Spieler eingeben: ");
    while ( anzPlayer != 0) {
      println("Name Spieler"+i+": "); var namePlayer = scala.io.StdIn.readLine(); 
      if (createPlayer(namePlayer)) { anzPlayer -= 1; i += 1; } else println("Name bereits vergeben, wähle einen anderen nickname!")   
    }
  }
  
  def playerGetCard() : Int = {
    var getCard = 0; var bool = true;
    while (bool) {
      println("Drücke ... \n(1) um eine Karte vom Deck zu ziehen\n(2) um eine Karte vom Ablagestapel zu siehen\n") 
      try { val input = scala.io.StdIn.readInt(); getCard = input; if (!checkGetCard(getCard)) println("Nur Zahlen im Bereich von 1 - 2 eingeben!\n") else bool = false
      } catch { case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - 2 eingeben!\n") }
    }
    return getCard;
  }
  
  def playerOptions() : Int = {
    var bool = true; var input = 0;
    while (bool) {
      println("Drücke ... \n(1) um deine Phase abzulegen\n(2) um an eine Phase anzulegen\n(3) um deinen Zug zu beenden")
      try { input = scala.io.StdIn.readInt(); if(!checkPlayerOption(input)) println("Nur Zahlen im Bereich von 1 - 3 eingeben!\n")
      } catch { case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - 3 eingeben!\n") }
    }
    return input;
  }
  
  def matchCase(name:String,i:Int) {
    i match {
      case 1 =>  
      case 2 =>
      case 3 => finishTurn(name)
    }
  }
  
  def finishTurn(name:String) {
    var bool = true; var input = 0;
    while (bool) { 
      println("Drücke ... \n(1) um eine Karte auf den Ablagestapel zu legen und deinen zug zu beenden")
      println("(2) um einen Spieler zu stoppen und deinen Zug zu beenden")
      try { input = scala.io.StdIn.readInt(); if(!checkGetCard(input)) println("Nur Zahlen im Bereich von 1 - 2 eingeben!\n")
      } catch { case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - 2 eingeben!\n") }
    }
    input match  {
      case 1 => 
      case 2 =>
    }
  }
}

class Tui () {
	helperMethods.nameOfPlayer()
	println("Alle Mitspieler: " + getPlayerList())
	
	var boolRound = true
	while (boolRound) {
	  for (x<- getPlayer()) {
	    println(x.toUpperCase() + " IST AM ZUG:")
	    println("Die Karten werden ausgegeben .... ")
	    println("Der Ablagestapel: " + getStack())
	    println(x + " deine Handkarten:\n" + getHandCards(x))
	    var getCard = helperMethods.playerGetCard()
	    println("Deine gezogene Karte: " + getGetCard(x,getCard))
	    var getPlayerOption = helperMethods.playerOptions()
	    helperMethods.matchCase(x,getPlayerOption)
	  }
	  boolRound = false
	}
}

