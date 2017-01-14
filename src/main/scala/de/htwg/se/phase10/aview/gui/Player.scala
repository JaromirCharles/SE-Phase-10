package de.htwg.se.phase10.aview.gui

import swing._
import java.awt.Color
import de.htwg.se.phase10.controller.IController

class Player(gui:createGameField, playerName:String, controller:IController) extends SimpleSwingApplication {
  val color = new Color(0x00592D)
  override def top = new MainFrame {

    val returnButton = new Button {
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      borderPainted = true
      action = Action("Return") {
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
          dispose()
        } else if (!controller.checkRemoveBreak()) {
          gui.infoFeld.turnPhase.text_=("You dont have a stop card!")
          dispose()
        } else if (controller.getBreak(name)) {
          gui.infoFeld.turnPhase.text_=("Player is already stopped!")
          dispose()
        } else {
          controller.setBreak(playerName)
          gui.handCards.updateHand()
          gui.player.updateButtons()
          controller.setPlayerNumber()
          controller.notifyObservers
          gui.handCards.updateHand()
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
          dispose()
        } else if (!controller.getMove()) {
          gui.infoFeld.turnPhase.text_=("Do the phase first!")
          dispose()
        }
        else {
          
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
          dispose()
        } else if (!controller.getMove()) {
          gui.infoFeld.turnPhase.text_=("Do the phase first!")
          dispose()
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
}