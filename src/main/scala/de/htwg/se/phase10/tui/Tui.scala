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
      println("Drücke ... \n(1) um eine Karte vom Deck zu ziehen\n(2) um eine Karte vom Ablagestapel zu siehen") 
      try { val input = scala.io.StdIn.readInt(); getCard = input; if (!checkGetCard(getCard)) println("Nur Zahlen im Bereich von 1 - 2 eingeben!") else bool = false
      } catch { case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - 2 eingeben!") }
    }
    return getCard;
  }
  
  def playerOptions() : Int = {
    var bool = true; var input = 0;
    while (bool) {
      println("Drücke ... \n(1) um deine Phase abzulegen\n(2) um an eine Phase anzulegen\n(3) um deinen Zug zu beenden")
      try { input = scala.io.StdIn.readInt(); if(!checkPlayerOption(input)) println("Nur Zahlen im Bereich von 1 - 3 eingeben!") else bool = false
      } catch { case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - 3 eingeben!") }
    }
    return input;
  }
  
  def matchCase(name:String,i:Int) {
    i match {
      case 1 =>println("hier1") 
      case 2 =>println("hier2")
      case 3 =>finishTurn(name)
    }
  }
  
  def finishTurn(name:String) {
    var bool = true; var input = 0;
    while (bool) { 
      println("Drücke ... \n(1) um eine Karte auf den Ablagestapel zu legen und deinen zug zu beenden")
      println("(2) um einen Spieler zu stoppen und deinen Zug zu beenden")
      try { input = scala.io.StdIn.readInt(); if(!checkGetCard(input)) println("Nur Zahlen im Bereich von 1 - 2 eingeben!\n") else bool = false
      } catch { case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - 2 eingeben!\n") }
    }
    input match  {
      case 1 => putCard(name)
      case 2 => stopPlayer(name)
    }
  }
  
  def yourTurn(name:String) : Boolean ={
    if (checkBreak(name)) {println(name + " ist gestoppt und muss aussetzen!"); return false;}
    println(name + " ist am Zug...")
    return true;
  }
  
  def putCard(name:String) {
    var input = 0; var size = (getHandSize(name)).toString();
    var bool = true
    while (bool) {
      println("Wähle eine Karte die du wegschmeißen willst:\n" + getIndexCardList(name))
      try { input = scala.io.StdIn.readInt(); if(!(input >= 1 && input <= getHandSize(name))) println("Nur Zahlen im Bereich von 1 - " +size+" eingeben!\n") 
                                              else { putCardStack(name,input); bool = false;}
      } catch {case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - " + size+" eingeben!\n")} 
    }
  }
  
  def stopPlayer(name:String) {
    if (!checkBreakCard(name)) {
      println(name + " du hast kein Stopper auf der Hand, somit kannst du auch niemanden stoppen!")
      finishTurn(name);
    }
    var input = 0;
    var bool = true
    println("Wählen Sie den Spieler aus der gestoppt werden soll:\n" + getStopPlayerList(name))
    while (bool) {
      try { input = scala.io.StdIn.readInt(); if(!checkPlayerStop(input)) println("Spieler konnte nicht gestoppt werden!\n") else bool = false
      } catch {case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - " + (getPlayer().size - 1).toString() +" eingeben!\n")} 
    }
  }
}

class Tui () {
	helperMethods.nameOfPlayer()
	println("Alle Mitspieler: " + getPlayerList())
	while (getPhase(getPlayer()) != 10) {
	  var bool = true
	  println("Deck wird gemischelt und Ablagestapel erzeugt ..." )
	  createDeckStack()
	  println("Die Karten werden ausgegeben .... ")
	  for(x<- getPlayer()) givePlayerHandCards(x)
	  while(bool) {
	    for (x<- getPlayer()) {
	      breakable{
	        println("--------------------------------------------------------------")
	        if (!helperMethods.yourTurn(x)) {setBreak(x); break;}
	        println("Der Ablagestapel: " + getStack())
	        println(x + " deine Handkarten:\n" + getHandCards(x))
	        var getCard = helperMethods.playerGetCard()
	        println("Deine gezogene Karte: " + getGetCard(x,getCard))
	        println(x + " deine Handkarten:\n" + getHandCards(x))
	        var playerOption = helperMethods.playerOptions()
	        helperMethods.matchCase(x, playerOption)
	      }
	    }
    }
	}
}

