package de.htwg.se.phase10.aview.gui

import swing._
import swing.event._
import java.awt.Color
import de.htwg.se.phase10.controller.IController

class MoveCards(gui:createGameField,controller:IController) extends SimpleSwingApplication {
  val color = new Color(0x00592D)
  
  override def top = new MainFrame {
    
    def cards = new FlowPanel {
      if (controller.getPhaseNameNumber()._2 == 6) {
        contents += button1
        contents += button2
        contents += button3
        contents += button4
        contents += button5
        contents += button6
      } else if (controller.getPhaseNameNumber()._2 == 7) {
        contents += button1
        contents += button2
        contents += button3
        contents += button4
        contents += button5
        contents += button6
        contents += button7
      } else if (controller.getPhaseNameNumber()._2 == 8) {
        contents += button1
        contents += button2
        contents += button3
        contents += button4
        contents += button5
        contents += button6
        contents += button7
        contents += button8
      } else if (controller.getPhaseNameNumber()._2 == 9) {
        contents += button1
        contents += button2
        contents += button3
        contents += button4
        contents += button5
        contents += button6
        contents += button7
        contents += button8
        contents += button9
      }
      background = color
     }
    
    var ReturnButton = new Button {
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      borderPainted = true
      action = Action("Return") {
        gui.willMove = false
        controller.updateHand()
        gui.handCards.updateHand()
        dispose()
      }
    }
    
    var moveButton = new Button {
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      borderPainted = true
      action = Action("Move phase") {
        if (!controller.getPullCard()) {
          gui.infoFeld.turnPhase.text_=("Pull a card first!")
        } else {
          controller.movePhase()
          if (controller.getMove()) {
            gui.infoFeld.turnPhase.text_=("Phase achieved! Get rid of all your cards")
            gui.willMove = false
            dispose()
          } else {
            gui.willMove = false
            controller.updateHand()
            gui.handCards.updateHand()
            gui.infoFeld.turnPhase.text_=("Phase not completed!")
            dispose()
          }
        }
      }
    }
    
    def buttons = new FlowPanel {
      contents += ReturnButton
      contents += moveButton
      background_=(color)
    }
    
    contents = new BorderPanel() {
      layout(cards) = BorderPanel.Position.Center
      layout(buttons) = BorderPanel.Position.South
    }
    
    background = color
    title = "Move list"
    preferredSize = new Dimension(2560,1040)
    resizable_= (false)
  }
  
  var button1 = new Button {
    preferredSize_=(new Dimension(100,120))
    opaque_=(false)
    contentAreaFilled_=(false)
    borderPainted_=(true)
  }
  
  var button2 = new Button {
    preferredSize_=(new Dimension(100,120))
    opaque_=(false)
    contentAreaFilled_=(false)
    borderPainted_=(true)
  }
  
  var button3 = new Button {
    preferredSize_=(new Dimension(100,120))
    opaque_=(false)
    contentAreaFilled_=(false)
    borderPainted_=(true)
  }
  
  var button4 = new Button {
    preferredSize_=(new Dimension(100,120))
    opaque_=(false)
    contentAreaFilled_=(false)
    borderPainted_=(true)
  }
  
  var button5 = new Button {
    preferredSize_=(new Dimension(100,120))
    opaque_=(false)
    contentAreaFilled_=(false)
    borderPainted_=(true)
  }
  
  var button6 = new Button {
    preferredSize_=(new Dimension(100,120))
    opaque_=(false)
    contentAreaFilled_=(false)
    borderPainted_=(true)
  }
  
  var button7 = new Button {
    preferredSize_=(new Dimension(100,120))
    opaque_=(false)
    contentAreaFilled_=(false)
    borderPainted_=(true)
  }
  
  var button8 = new Button {
    preferredSize_=(new Dimension(100,120))
    opaque_=(false)
    contentAreaFilled_=(false)
    borderPainted_=(true)
  }
  
  var button9 = new Button {
    preferredSize_=(new Dimension(100,120))
    opaque_=(false)
    contentAreaFilled_=(false)
    borderPainted_=(true)
  }

  def checkMoveList : Boolean = {
    if (controller.getPhaseNameNumber()._2 == 6 && button6.icon != null) return false
    else if (controller.getPhaseNameNumber()._2 == 7 && button7.icon != null) return false
    else if (controller.getPhaseNameNumber()._2 == 8 && button8.icon != null) return false
    else if (controller.getPhaseNameNumber()._2 == 9 && button9.icon != null) return false
    return true
  }
  
  def updateMove {

    button1.icon_=(null)
    button2.icon_=(null)
    button3.icon_=(null)
    button4.icon_=(null)
    button5.icon_=(null)
    button6.icon_=(null)
    button7.icon_=(null)
    button8.icon_=(null)
    button9.icon_=(null)

    for ((value,index) <- controller.getPlayer().moveList.zipWithIndex) {
      index match {
        case 0 => button1.icon_=(value.getIcon)
        case 1 => button2.icon_=(value.getIcon)
        case 2 => button3.icon_=(value.getIcon)
        case 3 => button4.icon_=(value.getIcon)
        case 4 => button5.icon_=(value.getIcon)
        case 5 => button6.icon_=(value.getIcon)
        case 6 => button7.icon_=(value.getIcon)
        case 7 => button8.icon_=(value.getIcon)
        case 8 => button9.icon_=(value.getIcon)
      }
    }
  }
}