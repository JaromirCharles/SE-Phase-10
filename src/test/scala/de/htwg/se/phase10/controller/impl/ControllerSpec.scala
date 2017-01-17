package de.htwg.se.phase10.controller.impl

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import de.htwg.se.phase10.controller.GameStatus
import de.htwg.se.phase10.model.impl.Stack
import scala.collection.mutable.ListBuffer
import de.htwg.se.phase10.model.impl.Colors
import de.htwg.se.phase10.model.impl.Deck
import de.htwg.se.phase10.model.impl.Player
import de.htwg.se.phase10.model.impl.Stack
import de.htwg.se.phase10.model.impl.PlayerList
import de.htwg.se.phase10.model.impl.NormalCard
import de.htwg.se.phase10.model.impl.SpecialCard
import de.htwg.se.phase10.model.impl.CardType
import de.htwg.se.phase10.model._
import de.htwg.se.phase10.model.impl.PlayerList

@RunWith(classOf[JUnitRunner])
class ControllerSpec extends WordSpec {

  "A new Controller" should {
    var deck:IDeck = new Deck
    var stack:Stack = new Stack() 
    var playerList:IPlayerList = new PlayerList()
    var controller = new Controller(deck, stack:IStack, playerList)

    "have a roundover" in {
      controller.roundOver should be(false)
    }

    "have a gameOver" in {
      controller.gameOver should be(false)
    }

    "have a gameStatus" in {
      controller.gameStatus should be(GameStatus.Welcome)
    }

    "have a newGameValue" in {
      controller.newGameValue should be(false)
    }

    "have a playernumber" in {
      controller.playerNumber should be(0)
    }

    "have a countPlayer" in {
      controller.countPlayer should be(0)
    }

    "have a playerMovedList" in {
      controller.playerMovedList should be(0)
    }
    
    "have a numberAllPlayer" in {
      controller.numberAllPlayer should be(0)
    }

    "start a newGame" in {
      controller.newGame(true)
      controller.newGameValue should be(true)
      controller.gameStatus should be(GameStatus.NewGame)
      controller.checkNewGame() should be(controller.newGameValue)
      controller.getStatus() should be(controller.gameStatus)
    }

    "finish a newGame" in {
      controller.newGame(false)
      controller.newGameValue should be(false)
      controller.checkNewGame() should be(controller.newGameValue)
    }

    "quit a game" in {
      controller.quitGame()
      controller.gameStatus should be(GameStatus.ExitGame)
      controller.getStatus() should be(controller.gameStatus)
    }
    
    "get number of all players" in {
      controller.setNumberAllPlayer(2)
      controller.getNumberAllPlayer should be(controller.getNumberAllPlayer)
    }

    "get a Stack" in {
      controller.getStack() should be(controller.getStack())
    }

    "get a emptyStack" in {
      stack.stack = stack.stack.drop(stack.stackSize)
      controller.getStack() should be("---- Empty ----")
    }
  }

  "A Stack " should {
    var deck:IDeck = new Deck
    var stack:Stack = new Stack()
    var playerList:IPlayerList = new PlayerList()
    var controller = new Controller(deck, stack:IStack, playerList)
    deck.createShuffleDeck
    stack.createStack(deck)

    "have a size" in {
      controller.getStackSize() should be(stack.stack.size)
    }

    "have a top card" in {
      val firstcard = stack.stack.head
      controller.getStackCard() should be(firstcard)
    }
  }

  "A player" should {
    var deck:IDeck = new Deck
    var stack:Stack = new Stack()
    var playerList:IPlayerList = new PlayerList()
    var controller = new Controller(deck, stack:IStack, playerList)
    controller.createPlayer("Jaromir")
    controller.setPlayerNumber()

    "have a name" in {
      controller.getName() should be("Jaromir")
    }

    "have a turn" in {
      var list = new ListBuffer[String]
      controller.getPlayerTurn() should be(list += "Jaromir")    
    }

    "have a player List" in {
      controller.getPlayerList() should be("(1) Jaromir\n")
    }

    "have hand cards" in {
      deck.createShuffleDeck
      stack.createStack(deck)
      controller.givePlayerHandCards()
      for (player <- playerList.getPlayerList) {
        player.hand.size should be(10)
      } 
    }

    "show the cards" in {
    var index = 0
    var returnString = ""
    for (card <- controller.getPlayer().hand) {
      index += 1
      returnString += "("+index+") " + card + "\n"
    }
      controller.getHand() should be(returnString)
    }

    "have a handsize" in {
      controller.getHandSize() should be(10)
    }

    "have a phase name and number" in {
    for (i <- 1 to 10) {
      controller.getPlayer().checkPhase = i
      if(i == 1) {
        controller.getPhaseNameNumber()._1 should be ("2 Drillinge")
        controller.getPhaseNameNumber()._2 should be (6)
      } else if(i == 2) {
        controller.getPhaseNameNumber()._1 should be ("1 Drilling + 1 Viererfolge")
        controller.getPhaseNameNumber()._2 should be (7)
      } else if(i == 3) {
        controller.getPhaseNameNumber()._1 should be ("1 Vierling + 1 Viererfolge")
        controller.getPhaseNameNumber()._2 should be (8)
      } else if(i == 4) {
        controller.getPhaseNameNumber()._1 should be ("1 Siebenerfolge")
        controller.getPhaseNameNumber()._2 should be (7)
      } else if(i == 5) {
        controller.getPhaseNameNumber()._1 should be ("1 Achterfolge")
        controller.getPhaseNameNumber()._2 should be (8)
      } else if(i == 6) {
        controller.getPhaseNameNumber()._1 should be ("1 Neunerfolge")
        controller.getPhaseNameNumber()._2 should be (9)
      } else if(i == 7) {
        controller.getPhaseNameNumber()._1 should be ("2 Vierlinge")
        controller.getPhaseNameNumber()._2 should be (8)
      } else if(i == 8) {
        controller.getPhaseNameNumber()._1 should be ("7 Karten einer Farbe")
        controller.getPhaseNameNumber()._2 should be (7)
      } else if(i == 9) {
        controller.getPhaseNameNumber()._1 should be ("1 Fünfling + 1 Zwilling")
        controller.getPhaseNameNumber()._2 should be (7)
      } else if(i == 10) {
        controller.getPhaseNameNumber()._1 should be ("1 Fünfling + 1 Drilling")
        controller.getPhaseNameNumber()._2 should be (8)
      }
     }
    }

    "not have a moveList" in {
      controller.getMoveList() should be("----- Nobody did this phase ----")
    }

    "have a moveList" in {
      var normal = NormalCard(Colors.Red, 10)
      controller.getPlayer().moved = true
      controller.getPlayer().moveList += normal
      controller.getMoveList() should be("Jaromir: " + controller.getPlayer().moveList.mkString(" ,")+"\n")
      controller.getPlayer().moved = false
    }

    "have a solo move List" in {
      controller.getPlayerMoveList() should be(" | Red 10")
    }

    "add a card to move list" in {
      controller.addToMoveList(1)
    }

    "move his phase wrong" in {
      controller.movePhase()
      controller.getMove() should be(false)
    }

    "can update his hand" in {
      controller.updateHand()
      controller.getPlayer().moveList.size should be(0)
    }

    "move his phase right" in {
      controller.getPlayer().checkPhase = 1
      controller.getPlayer().addCard(NormalCard(Colors.Green,10))
      controller.getPlayer().addCard(NormalCard(Colors.Yellow,10))
      controller.getPlayer().addCard(SpecialCard(CardType.Joker))
      controller.getPlayer().addCard(SpecialCard(CardType.Joker))
      controller.getPlayer().addCard(NormalCard(Colors.Red,9))
      controller.getPlayer().addCard(NormalCard(Colors.Purple,9))
      controller.movePhase()
      controller.getMove() should be(true)
    }

    "take a card from deck" in {
      var firstcard = deck.getDeck(1).head
      controller.getCardDeck() should be(firstcard.toString())
      controller.getPullCard() should be(true)
    }

    "take a card from recreateddeck" in {
      stack.stack = deck.getDeck(deck.getDeckSize)
      deck.dropDeck(deck.getDeckSize)
      controller.getCardDeck()
    }

    "take a card from stack" in {
      var firstcard = stack.stack.head
      controller.getCardStack() should be(firstcard.toString())
    }

    "take a card from empty stack" in {
      stack.stack = Nil
      var firstcard = deck.getDeck(1).head
      controller.getCardStack() should be(firstcard.toString())
    }

    "have a player Number" in {
      controller.getPlayerNumber() should be(0)
    }

    "set a player number" in {
      controller.createPlayer("maxi")
      controller.setPlayerNumber()
      controller.setPlayerNumber()
    }

    "drop a card to stack" in {
      val dropCard = controller.getPlayer().hand(0)
      controller.dropCardStack(1) should be(dropCard.toString())
    }

    "drop a card to stack and finishRound" in {
      val list = new ListBuffer[ICard]
      list += NormalCard(Colors.Green, 10)
      controller.getPlayer().hand = list
      controller.dropCardStack(1)should be("Green 10")
      controller.roundOver should be(true)
    }

    "drop a card to stack and finishGame" in {
      controller.getPlayer().checkPhase = 10
      val list = new ListBuffer[ICard]
      list += NormalCard(Colors.Green, 10)
      controller.getPlayer().hand = list
      controller.dropCardStack(1)should be("Green 10")
      controller.gameOver should be(true)
    }

    "should be stopped" in {
      controller.getPlayer().setBreak
      controller.getBreak(controller.getPlayer().name) should be(true)
      controller.skipPlayer(controller.getPlayer().name)
    }

    "should not be stopped" in {
      controller.getBreak(controller.getPlayer().name) should be(false)
      controller.createPlayer("nico")
      controller.getBreak("nico") should be(false)
      controller.skipPlayer("nico")
    }

    "stop someone" in {
      controller.stopPlayer(2)
      controller.stopPlayer(2)
      controller.stopPlayer(1)
      controller.stopPlayer(1)
    }

    "have a break card on his hand" in {
      controller.getPlayer().hand.+=(SpecialCard(CardType.Joker))
      controller.getPlayer().hand.+=(SpecialCard(CardType.Break))
      controller.checkRemoveBreak() should be(true)
    }

    "have not break card on his hand" in {
      controller.getPlayer().hand.clear()
      controller.checkRemoveBreak() should be(false)
      controller.getPlayer().hand += SpecialCard(CardType.Joker)
      controller.checkRemoveBreak() should be(false)
    }
  }

  "A game" should {
    var deck:IDeck = new Deck
    var stack:Stack = new Stack()
    var playerList:IPlayerList = new PlayerList()
    var controller = new Controller(deck, stack:IStack, playerList)
    controller.createPlayer("Nico")
    controller.createPlayer("Artur")

    "return a Player for a name" in {
      controller.getPlayer(controller.getPlayer().name) should be(controller.getPlayer())
    }

    "should start a new Round" in {
      controller.startNewRound()
    }

    "set the next phase for the player" in {
      for (i <- 1 to 10) {
        controller.getPlayer("Nico").moved = true
        controller.getPlayer("Artur").checkPhase = i
        controller.setNextPhase()
      }
    }

    "have a false roundOver" in {
      controller.getRoundOver() should be(false)
    }

    "have a false gameOver" in {
      controller.getGameOver() should be(false)
    }
  }

  "Some player" should {
    var deck:IDeck = new Deck
    var stack:Stack = new Stack()
    var playerList:IPlayerList = new PlayerList()
    var controller = new Controller(deck, stack:IStack, playerList)
    controller.createPlayer("Maxi")
    controller.createPlayer("Jaromir")
    controller.createPlayer("Artur")
    deck.createShuffleDeck
    stack.createStack(deck)

    val liste = new ListBuffer[ICard]
    liste += NormalCard(Colors.Green, 6)
    liste += NormalCard(Colors.Yellow, 6)
    liste += NormalCard(Colors.Red, 6)
    liste += NormalCard(Colors.Green, 7)
    liste += NormalCard(Colors.Green, 7)
    liste += NormalCard(Colors.Purple, 7)

    controller.getPlayer("Artur").hand += NormalCard(Colors.Purple, 7)
    controller.getPlayer("Maxi").hand = liste
    controller.getPlayer("Maxi").hand += NormalCard(Colors.Purple, 7)
    controller.getPlayer("Maxi").hand += NormalCard(Colors.Purple, 7)
    controller.getPlayer("Jaromir").hand = liste
    controller.getPlayer("Jaromir").hand += NormalCard(Colors.Green, 1)
    controller.getPlayer("Maxi").hand += NormalCard(Colors.Purple, 7)

    "do their phase" in {

    }
  }
  
  "A player adding" should {
    var deck:IDeck = new Deck
    var stack:Stack = new Stack()
    var playerList:IPlayerList = new PlayerList()
    var controller = new Controller(deck, stack:IStack, playerList)
    controller.createPlayer("Maxi")
    controller.createPlayer("Jaromir")
    val liste = new ListBuffer[ICard]
    liste += NormalCard(Colors.Green, 6)
    liste += NormalCard(Colors.Yellow, 6)
    liste += NormalCard(Colors.Red, 6)
    liste += NormalCard(Colors.Green, 7)
    liste += NormalCard(Colors.Green, 7)
    liste += NormalCard(Colors.Purple, 7)
    liste += NormalCard(Colors.Purple, 7)
    
    controller.getPlayer().hand = liste.drop(6)
    controller.getPlayer().moveList = liste.take(6)
    controller.movePhase()
    "add card to list" in {
      controller.addCardToList(1, 1, 2) should be(true)
      controller.getPlayer().hand = liste.take(1)
      controller.addCardToList(1, 1, 1) should be(true)
    }
    
    "do not add a card to list" in {
      liste.clear()
      liste += NormalCard(Colors.Green, 10)
      controller.getPlayer().hand = liste
      controller.addCardToList(1, 1, 1) should be(false)
      controller.addCardToList(1, 1, 2) should be(false)
    }
    
    "some other player cant add cards if they not out" in {
      controller.setPlayerNumber()
      liste += NormalCard(Colors.Green, 6)
      liste += NormalCard(Colors.Yellow, 6)
      liste += NormalCard(Colors.Red, 6)
      liste += NormalCard(Colors.Green, 7)
      liste += NormalCard(Colors.Green, 7)
      liste += NormalCard(Colors.Purple, 7)
      liste += NormalCard(Colors.Purple, 7)
      controller.getPlayer().hand = liste
      
      controller.addCardToList(1, 1, 1) should be(false)
      controller.addCardToList(1, 1, 2) should be(false)
    }
    
    "if playerlist is zero you cant add to list" in {
      var deck2:IDeck = new Deck
      var stack2:Stack = new Stack()
      var playerList2:PlayerList = new PlayerList
      var controller2 = new Controller(deck2,stack2,playerList2)
      controller.addCardToList(1, 1, 1) should be(false)
    }
//    "check add" in {
//      var varDeck =  deck.createShuffleDeck
//      var varStack = stack.createStack(deck)
//      val testPlayer = new Player("Jaromir",deck, stack)
//      controller.checkAdd(testPlayer.asInstanceOf[de.htwg.se.phase10.model.impl.Player])
//    }
  }
}
                                                                                       
                                                                                          
                                                                                      
                                                                                      
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                      
                                                                                    
                                                                                      
                                                                                        
                                                                                
                                                                                    
                                                                                  
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                  
                                                                                      
                                                                                      
                                                                                    
                                                                                        
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                  
                                                                                      
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                    
                                                                                
                                                                                
