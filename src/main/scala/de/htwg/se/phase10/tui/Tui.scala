package de.htwg.se.phase10.tui
import de.htwg.se.phase10.controller.CheckPlayer._
import de.htwg.se.phase10.controller.CheckCard._
import scala.util.control.Breaks._
import scala.util.control._

object helperMethods {
  
    // anzahl der Spieler eingeben  
    def numberOfPlayer() : Int = {
    var bool = true
    var anzPlayer = 0
    while (bool) { 
      println("Anzahl der Spieler eingeben (zwischen 2 - 4): ");
      try { anzPlayer = scala.io.StdIn.readInt(); 
        if (!checkAnzPlayer(anzPlayer)) 
          println("Nur Zahlen im Bereich von 2 - 4 eingeben!") 
        else bool = false
      } catch { 
        case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 2 - 4 eingeben!")
      }
    } 
    return anzPlayer;
  }
  
  //eindeutigen Namen für jeden Spieler eingeben
  def nameOfPlayer() {
    var numberPlayer = 1
    var anzPlayer = numberOfPlayer()
    var i = 1
    println("Namen der Spieler eingeben: ");
    while ( anzPlayer != 0) {
      println("Name Spieler"+i+": ")
      var namePlayer = scala.io.StdIn.readLine(); 
      if (createPlayer(namePlayer)) { 
        anzPlayer -= 1 
        i += 1 
      } else println("Name bereits vergeben, wähle einen anderen nickname!")   
    }
  }

  //Spieler zieht Karte vom Deck oder vom Ablagestapel
  def playerGetCard() : Int = {
    var getCard = 0
    var bool = true
    while (bool) {
      println("Drücke ... \n(1) um eine Karte vom Deck zu ziehen\n(2) um eine Karte vom Ablagestapel zu siehen") 
      try { 
        val input = scala.io.StdIn.readInt()
        getCard = input; 
        if (!checkGetCard(getCard)) 
          println("Nur Zahlen im Bereich von 1 - 2 eingeben!") 
        else bool = false
      } catch { 
        case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - 2 eingeben!") 
      }
    }
    return getCard;
  }
  
  //Spieler optionen Phase ablegen, an eine Phase anlegen oder Zug beenden
  def playerOptions() : Int = {
    var bool = true 
    var input = 0;
    while (bool) {
      println("Drücke ... \n(1) um deine Phase abzulegen\n(2) um an eine Phase anzulegen\n(3) um deinen Zug zu beenden")
      try { 
        input = scala.io.StdIn.readInt() 
        if(!checkPlayerOption(input)) 
          println("Nur Zahlen im Bereich von 1 - 3 eingeben!") 
        else bool = false
      } catch { 
        case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - 3 eingeben!") 
      }
    }
    return input;
  }
  
  //gewählte Option vom Spieler wird ausgeführt
  def matchCase(name:String,i:Int) {
    i match {
      case 1 =>checkPhase(name)
      case 2 =>println("hier2")
      case 3 =>finishTurn(name)
    }
  }
  
  //Option Spieler beendet seinen Zug, entweder anderen Spieler stoppen oder eine Karte auf den Ablagestapel legen
  def finishTurn(name:String) {
    var bool = true
    var input = 0
    while (bool) { 
      println("Drücke ... \n(1) um eine Karte auf den Ablagestapel zu legen und deinen zug zu beenden")
      println("(2) um einen Spieler zu stoppen und deinen Zug zu beenden")
      try { 
        input = scala.io.StdIn.readInt()
        if(!checkGetCard(input)) 
          println("Nur Zahlen im Bereich von 1 - 2 eingeben!\n") 
        else bool = false
      } catch { 
        case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - 2 eingeben!\n") 
      }
    }
    input match  {
      case 1 => putCard(name)
      case 2 => stopPlayer(name)
    }
  }
  
  //Spieler ist gestoppt und wird übersprungen
  def yourTurn(name:String) : Boolean ={
    if (checkBreak(name)) {
      println(name + " ist gestoppt und muss aussetzen!");
      return false
    }
    println(name + " ist am Zug...")
    return true
  }
  
  //Spieler legt karte auf Ablagestapel
  def putCard(name:String) {
    var input = 0
    var size = (getHandSize(name)).toString()
    var bool = true
    while (bool) {
      println("Wähle eine Karte die du wegschmeißen willst:\n" + getIndexCardList(name))
      try { 
        input = scala.io.StdIn.readInt()
        if(!(input >= 1 && input <= getHandSize(name))) 
          println("Nur Zahlen im Bereich von 1 - " +size+" eingeben!\n") 
        else { 
          putCardStack(name,input)
          bool = false
        }
      } catch {
        case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - " + size+" eingeben!\n")
      } 
    }
  }
  
  //Auswahl des Spielers den man stoppen will
  def stopPlayer(name:String) {
    if (!checkBreakCard(name)) {
      println(name + " du hast kein Stopper auf der Hand, somit kannst du auch niemanden stoppen!")
      finishTurn(name)
    } else {
      var input = 0
      var bool = true
      println("Wählen Sie den Spieler aus der gestoppt werden soll:\n" + getStopPlayerList(name))
      while (bool) {
        try { 
          input = scala.io.StdIn.readInt()
          if (!checkPlayerStop(input)) {
            println("Spieler konnte nicht gestoppt werden!\n")
            stopPlayer(name)
          } else bool = false
        } catch {
          case inputString : NumberFormatException => println("Bitte eine Zahl zwischen 1 - " + (getPlayer().size - 1).toString() +" eingeben!\n")
        } 
      }
    }
  }
  
  //Check ob spieler alle Karten abgelegt hat
  def finishRound(name:String) = playerFinishedRound(name)
  
  def checkPhase(name:String) {
    val phase = getPhaseInt(name)
  }
}

class Tui () {
	helperMethods.nameOfPlayer()  //Eingabe von Anzahl und Namen der Spieler
	println("Alle Mitspieler: " + getPlayerList()) //Alle Mitspieler werden einmalig ausgegeben
	var gameBool = true
	val gameBreak = new Breaks
	gameBreak.breakable {
	while (gameBool) {
	  var boolTurn = true
	  println("Deck wird gemischelt und Ablagestapel erzeugt ..." )
	  createDeckStack()  //Deck wird erzeugt
	  println("Die Karten werden ausgegeben .... ")
	  for(x<- getPlayer()) givePlayerHandCards(x) //Jeder Spieler in der Playerlist bekommt seine 10 Handkarten
	  val roundBreak = new Breaks
	  roundBreak.breakable{
	  while(boolTurn) {
	      for (x<- getPlayer()) {  //Jeder Spieler ist nacheinander am Zug
	        val stopBreak = new Breaks
	        stopBreak.breakable{
	          println("--------------------------------------------------------------")
	          if (!helperMethods.yourTurn(x)) {setBreak(x); stopBreak.break;} //Checken ob Spieler gestoppt sonst ist er am Zug
	          println("Deine aktuelle Phase: " + getPhase(x))  //Anzeigen welche Phase er erledigen muss
	          println("Der Ablagestapel: " + getStack())  //Anzeigen der ersten Karte auf dem Ablagestapel
	          println(x + " deine Handkarten:\n" + getIndexCardList(x))  //Anzeigen der Handkarten von dem Spieler der an der Reihe ist
	          var getCard = helperMethods.playerGetCard()  //Vom Deck oder Stapel ziehen
	          println("Deine gezogene Karte: " + getGetCard(x,getCard)) //Ausgabe der gezogenen Karte
	          println(x + " deine Handkarten:\n" + getIndexCardList(x))  //erneutes Anzeigen der Karten
	          var playerOption = helperMethods.playerOptions()  //Optionen des Spielers
	          helperMethods.matchCase(x, playerOption)  //Für was hat er sich entschieden
	          if (helperMethods.finishRound(x) && getPhaseInt(x) != 10) {  //Checken ob Spieler alle Karten abgelegt hat und in welcher Phase er ist
	            println("Runde ist vorbei...")  //Falls er alle Karten abgelegt hat und noch nicht in der 10 Phase war wird eine neue Runde gestartet
              println("Spieler " + x + " hat alle Karten abgelegt!")
              println("Phasenübersicht:")
              println("--------------------------------------------------------------")
              changePlayerList()  //Der Spieler der als erstes ziehen durfte kommt jetzt als letztes und sein "Nebensitzer" darf als erstes ziehen
	            roundBreak.break;
	          }else if(helperMethods.finishRound(x) && getPhaseInt(x) == 10) {  //Check ob Spieler alle Karten abgelegt hat und in letzter Phase ist
	              gameBool = false;  //Dann wird das Spiel beendet und der Spieler hat gewonnen
	              println("--------------------------------------------------------------")
	              println("Das Spiel ist vorbei!")
	              println("DER GEWINNER IST " + x)
	              gameBreak.break
	            }
	         }
	    }
	   }
    }
	}
	}
}

