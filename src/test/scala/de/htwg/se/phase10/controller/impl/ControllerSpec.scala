//package de.htwg.se.phase10.controller.impl
//
//import org.scalatest.WordSpec
//import org.scalatest.Matchers._
//import org.junit.runner.RunWith
//import org.scalatest.junit.JUnitRunner
//import de.htwg.se.phase10.controller.GameStatus
//import de.htwg.se.phase10.model.impl.Stack
//
//@RunWith(classOf[JUnitRunner])
//class ControllerSpec extends WordSpec {
//  
//  "A new Controller" should {
//    var controller = new Controller
//    
//    "have a roundover" in {
//      controller.roundOver should be(false)
//    }
//    
//    "have a gameOver" in {
//      controller.gameOver should be(false)
//    }
//    
//    "have a gameStatus" in {
//      controller.gameStatus should be(GameStatus.Welcome)
//    }
//    
//    "have a newGameValue" in {
//      controller.newGameValue should be(false)
//    }
//    
//    "have a playernumber" in {
//      controller.playerNumber should be(0)
//    }
//    
//    "have a countPlayer" in {
//      controller.countPlayer should be(0)
//    }
//    
//    "have a playerMovedList" in {
//      controller.playerMovedList should be(0)
//    }
//    
//    "start a newGame" in {
//      controller.newGame(true)
//      controller.newGameValue should be(true)
//      controller.gameStatus should be(GameStatus.NewGame)
//      controller.checkNewGame() should be(controller.newGameValue)
//      controller.getStatus() should be(controller.gameStatus)
//    }
//    
//    "finish a newGame" in {
//      controller.newGame(false)
//      controller.newGameValue should be(false)
//      controller.checkNewGame() should be(controller.newGameValue)
//    }
//    
//    "quit a game" in {
//      controller.quitGame()
//      controller.gameStatus should be(GameStatus.ExitGame)
//      controller.getStatus() should be(controller.gameStatus)
//    }
//    
//    "get a Stack" in {
//      controller.createStackDeck()
//      controller.getStack() should be(Stack.stack.head.toString())
//    }
//    
//    "get a emptyStack" in {
//      controller.createStackDeck()
//      Stack.stack = Stack.stack.drop(1)
//      controller.getStack() should be("---- Empty ----")
//    }
//    
//  }
//}