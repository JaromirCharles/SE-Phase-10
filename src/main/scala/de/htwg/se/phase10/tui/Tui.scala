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
    var bool = true;
    while (true) {
      println("Drücke ... \n(1) um deine Handkarten anzeigen zu lassen\n(2) um deine Phase abzulegen\n(3) um eine Karte auf den Ablagestapel zu legen und deinen Zug zu beenden\n")
      print("(4) um einen Spieler zu stoppen und deinen Zug zu beenden\n") 
    }
    return 0;
  }
}

class Tui () {
	helperMethods.nameOfPlayer()
	println("Alle Mitspieler: " + getPlayerList())
	println("Der Ablagestapel: " + getStack())
	
	var boolRound = true
	while (boolRound) {
	  for (x<- getPlayer()) {
	    println(x + " IST AM ZUG:\n")
	    var getCard = helperMethods.playerGetCard()
	    println("Deine gezogene Karte: " + getGetCard(x,getCard))

	  }
	  boolRound = false
	}
}

