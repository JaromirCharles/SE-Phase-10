package de.htwg.se.phase10.aview.gui

import swing._
import javax.swing.ImageIcon
import de.htwg.se.phase10.util.Observer.IObserver
import de.htwg.se.phase10.util.Observer.Event
import de.htwg.se.phase10.controller.IController
import de.htwg.se.phase10.controller.UpdateStack
import de.htwg.se.phase10.controller.StartGame
import de.htwg.se.phase10.controller.AddPlayer

class MainField(controller:IController) {
  val gameField = new createGameField(controller)
  gameField.visible_=(true)
}

class createGameField(controller:IController) extends Frame with IObserver {
  controller.addObserver(this)
  controller.setPlayerNumber()
  var willMove = false
  var moveListFull = false
  val deckStack = new DeckStack(this,controller)
  val move = new MoveCards(this,controller)
  move.top.visible_=(false)
  val infoFeld = new GameInformation(controller)
  controller.givePlayerHandCards()
  val handCards = new PlayerHand(this,controller)
  val phasen = new Phasen(this,controller.getName(),controller)
  val player = new AllPlayer(this,controller)
  val color = new Color(0x00592D)
  controller.notifyObservers
  menuBar = new MenuBar {
    contents += new Menu("Game Menu") {
      contents += new MenuItem( new Action("Exit Game ...") {
        def apply = exitMenu(menuBar)
      })
    }
  }

  val phasenOwerview = new ImageIcon(new ImageIcon("./img/phasen.jpg").getImage().getScaledInstance(100,120, java.awt.Image.SCALE_SMOOTH))

  contents = new BorderPanel() {
    background = color
    border = Swing.EmptyBorder(15,15,15,15)
    layout(infoFeld.infoText) = BorderPanel.Position.North
    layout(phasen.phasenCard) = BorderPanel.Position.East
    layout(deckStack.deckStack) = BorderPanel.Position.West
    layout(handCards.cards) = BorderPanel.Position.South
    layout(player.allPlayer) = BorderPanel.Position.Center
  }
  title = "Gamefield"
  preferredSize = new Dimension(2560,1540)
  resizable_= (true)

  def exitMenu(parent:Component) {
    val res = Dialog.showConfirmation(parent, "Do you really want to quit?",
      optionType=Dialog.Options.YesNo,title="Exit Game")
    if (res == Dialog.Result.Yes) {
      controller.quitGame()
      sys.exit(0)
    }
    else if (res == Dialog.Result.No) return
  }

  override def update(e:Event) {
    if (e.isInstanceOf[UpdateStack]) {
      deckStack.updateStack()
    } else {
      if (controller.getBreak(controller.getName())) {
        controller.skipPlayer(controller.getName())
      }
      infoFeld.turnPhase.text_=("Its your turn " + controller.getName() +"\nYour current Phase: " + controller.getPhaseNameNumber()._1)
      handCards.updateHand()
    }
  }
}