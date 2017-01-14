package de.htwg.se.phase10.aview.gui

import swing._
import swing.event._
import de.htwg.se.phase10.controller.IController
import java.awt.Color
import javax.swing.ImageIcon

class DeckStack (gui:createGameField, controller:IController) extends Frame {
  val color = new Color(0x00592D)

  def deckStack = new FlowPanel {
    contents += deck
    contents += stack
    background_=(color)
  }

  val deck = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.borderPainted_=(true)
    this.icon_=(new ImageIcon(new ImageIcon("./img/Phase10Deck.png").getImage().getScaledInstance(100,120, java.awt.Image.SCALE_SMOOTH)))
  }

  val stack = new Button {
    preferredSize_=(new Dimension(100,120))
    borderPainted_=(true)
    icon_=(controller.getStackCard().getIcon)
    opaque_=(false)
    contentAreaFilled_=(false)
  }

  listenTo(deck,stack)
  reactions += {
    case ButtonClicked(`stack`) if(!controller.getPullCard()) => controller.getCardStack();gui.handCards.updateHand();gui.deckStack.updateStack();gui.player.updateButtons()
    case ButtonClicked(`stack`) if(controller.getPullCard()) => gui.infoFeld.turnPhase.text_=("You Pulled a card already!")
    case ButtonClicked(`stack`) if(controller.getStackSize() == 0) => gui.infoFeld.turnPhase.text_=("Stack is empty, sou you pulled a card from the deck!")
    case ButtonClicked(`deck`) if(!controller.getPullCard()) => controller.getCardDeck();gui.handCards.updateHand();gui.player.updateButtons()
    case ButtonClicked(`deck`) if(controller.getPullCard()) => gui.infoFeld.turnPhase.text_=("You Pulled a card already!")
  }

  def updateStack() {
    if (controller.getStackSize() == 0) {
      stack.borderPainted_=(true)
      stack.icon_=(null)
      stack.opaque_=(false)
      stack.contentAreaFilled_=(false)
    } else {
      stack.icon_=(controller.getStackCard().getIcon)
    }
  }
}