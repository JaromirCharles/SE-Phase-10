package de.htwg.se.phase10.aview.tui

import de.htwg.se.phase10.controller.AddPlayer
import de.htwg.se.phase10.controller.ExitGame
import de.htwg.se.phase10.controller.IController
import de.htwg.se.phase10.controller.GameStatus
import de.htwg.se.phase10.controller.StartGame
import de.htwg.se.phase10.controller.UpdateStack
import de.htwg.se.phase10.util.Observer.IObserver
import de.htwg.se.phase10.util.Observer.Event

class Tui(var controller:IController) extends IObserver {

  private var boolInput = true
  private var numberOfPlayer = 1
  private var numberPlayerCount = 0
  private var quit = false

  controller.addObserver(this)

  printMainMenu()

  def inputString(input:String) : Boolean = {
    if (createPlayer(input)) {
      return true
    }
    if (input.equals("1") && controller.getStatus().equals(GameStatus.Welcome)) {
      controller.newGame(true)
    } else if (input.equals("2") && controller.getStatus().equals(GameStatus.Welcome)) {
      printQuitMenu()
      sys.exit(0)
    } else {
      return checkInput(input)
    }
    return true
  }

  def printMainMenu() {
    println("Welcome to Phase 10\n")
    println("Choose ...\n")
    println("(1) Start new Game")
    println("(2) Quit")
  }

  def printNumberPlayer() = println("Choose a player number between 2 - 4 ...")

  def createPlayer(input:String) : Boolean = {
    if (!controller.checkNewGame()) {
      return false
    }
    if (controller.checkNewGame() && numberOfPlayer == 1) {
      try {
        numberOfPlayer = input.toInt
        controller.setNumberAllPlayer(numberOfPlayer)
      } catch {
        case inputString : NumberFormatException => println("Only numbers between 2 - 4 are allowed!")
        printNumberPlayer()
        return true
      }
      if (numberOfPlayer < 2 || numberOfPlayer > 4) {
        println("Only numbers between 2 - 4 are allowed!")
        printNumberPlayer()
        numberOfPlayer = 1
        return true
      }
      println("Player 1  - name: ")
      numberPlayerCount += 1
      return true
    } else if (controller.checkNewGame() && numberPlayerCount < numberOfPlayer) {
      controller.createPlayer(input)
      numberPlayerCount += 1
      println("Player "+numberPlayerCount + " - name: ")
      return true
    } else if (controller.checkNewGame() && numberPlayerCount == numberOfPlayer) {
      controller.createPlayer(input)
      numberPlayerCount += 1
      println("Enter something to continue ... ")
      return true
    }
    if (numberPlayerCount > numberOfPlayer) {
      controller.newGame(false) 
      controller.givePlayerHandCards()
      controller.setPlayerNumber()
      printGameField(controller.getName())
      return true
    }
    return false
  }

  def printPlayer(name:String) = if (numberPlayerCount <= numberOfPlayer) println(controller.getStatus()+" - "+"name " +name)

  def printGameField(name:String) {
    if (controller.getBreak(name)) {
      println(name + " you skip this turn!")
      controller.skipPlayer(name)
      return printGameField(controller.getName())
    }
    println("-----------------------------------------------")
    println("It's your turn " + controller.getName() +"\n")
    println("Your current Phase: " + controller.getPhaseNameNumber()._1)
    println("All players ...")
    println(controller.getPlayerList())
    println("People which did this Phase already ... ")
    println(controller.getMoveList())
    println("Your move list: " + controller.getPlayerMoveList())
    println("First card of the Stack: " + controller.getStack())
    println("Your hand cards...\n" + controller.getHand()+"\n")
    println("Choose...")
    println("(1) get card from deck\n(2) get card from stack\n(3+number of card) drop card stack and finish turn\n(4+number of player) stop player and finish turn")
    println("(5+number of card) add card to moveList\n(6) move phase\n(7+number of existing phase+card index+index where to put) put card to an existing phase\n(8) quit game ")
  }

  def checkInput(input:String) : Boolean = {
    if (quit) return false
    var index = -1
    var inputMatch = input
    var indexPhase = -1
    var existingPhase = -1

    if (input.length() > 1 && input.length < 4)  {
      inputMatch = input.substring(0,1)
      try {
        index = input.substring(1).toInt
      } catch {
        case inputString : NumberFormatException => println("Not a correct index!")
        printGameField(controller.getName())
        return true 
      }
    } else if (input.length() == 4) {
      inputMatch = input.substring(0,1)
      try {
        existingPhase = input.substring(1,2).toInt
        index = input.substring(2,3).toInt
        indexPhase = input.substring(3).toInt
      } catch {
        case inputString : NumberFormatException => println("Not a correct input!")
        printGameField(controller.getName())
        return true 
      }
    }
    if (inputMatch.equals("3") && (index < 1 || index > controller.getHandSize())) {
      println("Not a correct card index!")
      printGameField(controller.getName())
      return true
    } else if (inputMatch.equals("4") && (index < 1 || index > numberOfPlayer)) {
      println(inputMatch.equals("4"))
      println(inputMatch)
      println("Not a correct player index!")
      printGameField(controller.getName())
      return true
    } else if (inputMatch.equals("5") && (index < 1 || index > controller.getHandSize())) {
      println("Not a correct card index!")
      printGameField(controller.getName())
      return true
    } else if (inputMatch.equals("7") & ((indexPhase < 1 || indexPhase > 2) || (index < 1 || index > controller.getHandSize()) || (existingPhase < 1 || existingPhase > numberOfPlayer))) {
      println("Not a correct input!")
      printGameField(controller.getName())
      return true
    }

    inputMatch match {
      case "1" if (!controller.getPullCard()) => println("Your pulled card is: " + controller.getCardDeck()) 
      case "1" if (controller.getPullCard()) => printPullAlready()
      case "2" if (!controller.getPullCard()) => println("Your pulled card is: " + controller.getCardStack()) 
      case "2" if (controller.getPullCard()) => printPullAlready()
      case "3" if (controller.getPullCard()) => println("You dropped " + controller.dropCardStack(index) + " to the stack!"); 
                                                if (controller.getRoundOver()) {println(controller.getStatus() + " - New round begins ...");controller.startNewRound();}
                                                else if (controller.getGameOver()) {println("Congratulation " + controller.getName() + " you won!"); return false }
                                                controller.setPlayerNumber()
      case "3" if (!controller.getPullCard()) => printPull()
      case "4" if (!controller.getPullCard()) => printPull()
      case "4" if (controller.getBreak(controller.getPlayerTurn()(index-1))) => println("Player is stopped at the moment, you cant stop him in this time again!")
      case "4" if (!controller.checkRemoveBreak()) => println("You dont have a stop card, yo you cant stop someone")
      case "4" if (!controller.getBreak(controller.getPlayerTurn()(index-1))) => controller.stopPlayer(index); println("Player " + controller.getPlayerTurn()(index - 1)  + " stopped");
                                                if (controller.getRoundOver()) {println(controller.getStatus() + " - New round begins ...");controller.startNewRound()}
                                                else if (controller.getGameOver()) {println("Congratulation " + controller.getName() + " you won!"); return false }
                                                controller.setPlayerNumber() 
      case "5" if (!controller.getPullCard) => printPull()
      case "5" if (controller.getMove()) => println("You did your phase already, you can only put a card to an existing phase!")
      case "5" => controller.addToMoveList(index)
      case "6" if (!controller.getPullCard) => printPull()
      case "6" if (controller.getMove()) => println("You did this phase already!")
      case "6" => controller.movePhase(); if (controller.getMove()) {println(controller.getStatus() + " - Phase achieved! Get rid of all your cards")} 
                                          else {controller.updateHand(); println("Phase not completed!")}
      case "7" if (!controller.getPullCard) => printPull()
      case "7" if (!controller.getMove()) => println("You have to do the phase first!") 
      case "7" if (controller.addCardToList(existingPhase, index, indexPhase)) => println("Card was regular!")
      case "7" => println("not a regular card")
      case "8" => controller.quitGame(); return false
      case default => println("Wrong Input!")
    }
    printGameField(controller.getName())
    return true
  }

  def printPull() = println("Pull a card first!")

  def printPullAlready() = println("You pulled a card already!")

  def printQuitMenu() {
    println(controller.getStatus() + " exit game ...")
  }

  override def update(e:Event) {
    if (e.isInstanceOf[ExitGame]) {
      quit = true
      printQuitMenu()
    } else if (e.isInstanceOf[StartGame]) {
      printNumberPlayer()
    } else if (e.isInstanceOf[AddPlayer]) {
      controller.setPlayerNumber()
      printPlayer(controller.getName())
    } else if (e.isInstanceOf[UpdateStack]) {
      println("Card from deck to stack...")
    } else {
      printGameField(controller.getName())
    }
  }
}