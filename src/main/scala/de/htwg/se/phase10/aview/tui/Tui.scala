package de.htwg.se.phase10.aview.tui

import de.htwg.se.phase10.controller.AddPlayer
import de.htwg.se.phase10.controller.ExitGame
import de.htwg.se.phase10.controller.IController
import de.htwg.se.phase10.controller.GameStatus
import de.htwg.se.phase10.controller.StartGame
import de.htwg.se.phase10.controller.UpdateStack
import de.htwg.se.phase10.util.Observer.IObserver
import de.htwg.se.phase10.util.Observer.Event
import javax.inject.Inject
import org.apache.log4j._


class Tui @Inject() (var controller:IController) extends IObserver {

  private var boolInput = true
  private var numberOfPlayer = 1
  private var numberPlayerCount = 0
  private var quit = false

  val logger = Logger.getLogger(getClass().getName())
  
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
    logger.info("Welcome to Phase 10\n")
    logger.info("Choose ...\n")
    logger.info("(1) Start new Game")
    logger.info("(2) Quit")
  }

  def printNumberPlayer() = logger.info("Choose a player number between 2 - 4 ...")

  def createPlayer(input:String) : Boolean = {
    if (!controller.checkNewGame()) {
      return false
    }
    if (controller.checkNewGame() && numberOfPlayer == 1) {
      try {
        numberOfPlayer = input.toInt
        controller.setNumberAllPlayer(numberOfPlayer)
      } catch {
        case inputString : NumberFormatException => logger.info("Only numbers between 2 - 4 are allowed!")
        printNumberPlayer()
        return true
      }
      if (numberOfPlayer < 2 || numberOfPlayer > 4) {
        logger.info("Only numbers between 2 - 4 are allowed!")
        printNumberPlayer()
        numberOfPlayer = 1
        return true
      }
      logger.info("Player 1  - name: ")
      numberPlayerCount += 1
      return true
    } else if (controller.checkNewGame() && numberPlayerCount < numberOfPlayer) {
      controller.createPlayer(input)
      numberPlayerCount += 1
      logger.info("Player "+numberPlayerCount + " - name: ")
      return true
    } else if (controller.checkNewGame() && numberPlayerCount == numberOfPlayer) {
      controller.createPlayer(input)
      numberPlayerCount += 1
      logger.info("Enter something to continue ... ")
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

  def printPlayer(name:String) = if (numberPlayerCount <= numberOfPlayer) logger.info(controller.getStatus()+" - "+"name " +name)

  def printGameField(name:String) {
    if (controller.getBreak(name)) {
      logger.info(name + " you skip this turn!")
      controller.skipPlayer(name)
      return printGameField(controller.getName())
    }
    logger.info("-----------------------------------------------")
    logger.info("It's your turn " + controller.getName() +"\n")
    logger.info("Your current Phase: " + controller.getPhaseNameNumber()._1)
    logger.info("All players ...")
    logger.info(controller.getPlayerList())
    logger.info("People which did this Phase already ... ")
    logger.info(controller.getMoveList())
    logger.info("Your move list: " + controller.getPlayerMoveList())
    logger.info("First card of the Stack: " + controller.getStack())
    logger.info("Your hand cards...\n" + controller.getHand()+"\n")
    logger.info("Choose...")
    logger.info("(1) get card from deck")
    logger.info("(2) get card from stack")
    logger.info("(3+number of card) drop card stack and finish turn")
    logger.info("(4+number of player) stop player and finish turn")
    logger.info("(5+number of card) add card to moveList")
    logger.info("(6) move phase")
    logger.info("(7+number of existing phase+card index+index where to put) put card to an existing phase")
    logger.info("(8) quit game")
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
        case inputString : NumberFormatException => logger.info("Not a correct index!")
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
        case inputString : NumberFormatException => logger.info("Not a correct input!")
        printGameField(controller.getName())
        return true 
      }
    }
    if (inputMatch.equals("3") && (index < 1 || index > controller.getHandSize())) {
      logger.info("Not a correct card index!")
      printGameField(controller.getName())
      return true
    } else if (inputMatch.equals("4") && (index < 1 || index > numberOfPlayer)) {
      logger.info(inputMatch.equals("4"))
      logger.info(inputMatch)
      logger.info("Not a correct player index!")
      printGameField(controller.getName())
      return true
    } else if (inputMatch.equals("5") && (index < 1 || index > controller.getHandSize())) {
      logger.info("Not a correct card index!")
      printGameField(controller.getName())
      return true
    } else if (inputMatch.equals("7") & ((indexPhase < 1 || indexPhase > 2) || (index < 1 || index > controller.getHandSize()) || (existingPhase < 1 || existingPhase > numberOfPlayer))) {
      logger.info("Not a correct input!")
      printGameField(controller.getName())
      return true
    }

    inputMatch match {
      case "1" if (!controller.getPullCard()) => logger.info("Your pulled card is: " + controller.getCardDeck()) 
      case "1" if (controller.getPullCard()) => printPullAlready()
      case "2" if (!controller.getPullCard()) => logger.info("Your pulled card is: " + controller.getCardStack()) 
      case "2" if (controller.getPullCard()) => printPullAlready()
      case "3" if (controller.getPullCard()) => logger.info("You dropped " + controller.dropCardStack(index) + " to the stack!"); 
                                                if (controller.getRoundOver()) {logger.info(controller.getStatus() + " - New round begins ...");controller.startNewRound();}
                                                else if (controller.getGameOver()) {logger.info("Congratulation " + controller.getName() + " you won!"); return false }
                                                controller.setPlayerNumber()
      case "3" if (!controller.getPullCard()) => printPull()
      case "4" if (!controller.getPullCard()) => printPull()
      case "4" if (controller.getBreak(controller.getPlayerTurn()(index-1))) => logger.info("Player is stopped at the moment, you cant stop him in this time again!")
      case "4" if (!controller.checkRemoveBreak()) => logger.info("You dont have a stop card, yo you cant stop someone")
      case "4" if (!controller.getBreak(controller.getPlayerTurn()(index-1))) => controller.stopPlayer(index); logger.info("Player " + controller.getPlayerTurn()(index - 1)  + " stopped");
                                                if (controller.getRoundOver()) {logger.info(controller.getStatus() + " - New round begins ...");controller.startNewRound()}
                                                else if (controller.getGameOver()) {logger.info("Congratulation " + controller.getName() + " you won!"); return false }
                                                controller.setPlayerNumber() 
      case "5" if (!controller.getPullCard) => printPull()
      case "5" if (controller.getMove()) => logger.info("You did your phase already, you can only put a card to an existing phase!")
      case "5" => controller.addToMoveList(index)
      case "6" if (!controller.getPullCard) => printPull()
      case "6" if (controller.getMove()) => logger.info("You did this phase already!")
      case "6" => controller.movePhase(); if (controller.getMove()) {logger.info(controller.getStatus() + " - Phase achieved! Get rid of all your cards")} 
                                          else {controller.updateHand(); logger.info("Phase not completed!")}
      case "7" if (!controller.getPullCard) => printPull()
      case "7" if (!controller.getMove()) => logger.info("You have to do the phase first!") 
      case "7" if (controller.addCardToList(existingPhase, index, indexPhase)) => logger.info("Card was regular!")
      case "7" => logger.info("not a regular card")
      case "8" => controller.quitGame(); return false
      case default => logger.info("Wrong Input!")
    }
    printGameField(controller.getName())
    return true
  }

  def printPull() = logger.info("Pull a card first!")

  def printPullAlready() = logger.info("You pulled a card already!")

  def printQuitMenu() {
    logger.info(controller.getStatus() + " exit game ...")
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
      logger.info("Card from deck to stack...")
    } else {
      printGameField(controller.getName())
    }
  }
}