package de.htwg.se.phase10.aview.gui

import swing._
import java.awt.Color
import de.htwg.se.phase10.controller.IController

class Player(gui:createGameField, playerName:String, controller:IController) extends SimpleSwingApplication {
  val color = new Color(0x00592D)
  
    val mainFrame = new MainFrame {

    val returnButton = new Button {
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      borderPainted = true
      action = Action("Return") {
        gui.willAddLeft = false
        gui.willAddRight = false
        gui.playerMenu = false
        dispose()
        controller.notifyObservers
      }
    }

    val stopPlayer = new Button {
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      borderPainted = true
      action = Action("Stop player") {
        if (!controller.getPullCard()) {
          gui.infoFeld.turnPhase.text_=("Pull a card first!")
          gui.playerMenu = false
          dispose()
        } else if (!controller.checkRemoveBreak()) {
          gui.infoFeld.turnPhase.text_=("You dont have a stop card!")
          gui.playerMenu = false
          dispose()
        } else if (controller.getBreak(name)) {
          gui.infoFeld.turnPhase.text_=("Player is already stopped!")
          gui.playerMenu = false
          dispose()
        } else {
          if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
          else if (controller.getGameOver()) {}   
          controller.setBreak(playerName)
          gui.handCards.updateHand()
          gui.player.updateButtons()
          controller.setPlayerNumber()
          controller.notifyObservers
          gui.handCards.updateHand()
          gui.playerMenu = false
          gui.willMove = false
          dispose()
        }
      }
    }

    val addCard1 = new Button {
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      preferredSize_=(new Dimension(200,120))
      borderPainted = true
      action = Action("Add a card") {
        if (!controller.getPullCard()) {
          gui.infoFeld.turnPhase.text_=("Pull a card first!")
          gui.playerMenu = false
          gui.willAddLeft = false
          dispose()
        } else if (!controller.getMove()) {
          gui.infoFeld.turnPhase.text_=("Do the phase first!")
          gui.willAddLeft = false
          gui.playerMenu = false
          dispose()
        }
        else {
          gui.willAddLeft = true
        }
      }
    }

    val addCard2 = new Button {
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      preferredSize_=(new Dimension(200,120))
      borderPainted = true
      action = Action("Add a card") {
        if (!controller.getPullCard()) {
          gui.infoFeld.turnPhase.text_=("Pull a card first!")
          gui.willAddRight = false
          dispose()
        } else if (!controller.getMove()) {
          gui.infoFeld.turnPhase.text_=("Do the phase first!")
          gui.willAddRight = false
          dispose()
        } else {
          gui.willAddRight = true
        }
      }
    }

    def buttons = new FlowPanel() {
      contents += returnButton
      contents += stopPlayer
      background = color
    }

    def phase = new FlowPanel() {
      contents += addCard1
      for(card <- controller.getPlayer(playerName).moveList) {
        contents += new Label {
          preferredSize_=(new Dimension(100,120))
          icon_=(card.getIcon)
        }
      }
      contents += addCard2
      background = color
    }

    contents = new BorderPanel() {
      layout(buttons) = BorderPanel.Position.South
      layout(phase) = BorderPanel.Position.Center
    }

    background = color
    title = "Player"
    preferredSize = new Dimension(2560,1040)
    resizable_= (false)
  }
  override def top = mainFrame
  
  def closeFrame() {
    gui.willAddLeft = false
    gui.willAddRight = false
    gui.playerMenu = false
    mainFrame.dispose()
  }
}