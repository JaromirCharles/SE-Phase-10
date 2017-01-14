package de.htwg.se.phase10.aview.gui

import swing._
import java.awt.Color
import de.htwg.se.phase10.controller.IController

class AllPlayer(gui:createGameField,controller:IController) extends Frame {
  val color = new Color(0x00592D)
  val player1Button = new Button {
    preferredSize_=(new Dimension(200,100)) 
    visible_=(false)
    background = color
    foreground_=(Color.WHITE)
    font_=(this.font.deriveFont(16f))
    borderPainted_=(true)
    action = Action("") {
      for ((value,index) <- controller.getPlayerTurn().zipWithIndex) {
        index match {
          case 0 => var player = new Player(gui,value,controller);player.top.visible_=(true)
          case default =>
        }
      }
    }
  }
  val player2Button = new Button {
    preferredSize_=(new Dimension(200,100))
    visible_=(false)
    background = color
    foreground_=(Color.WHITE)
    font_=(this.font.deriveFont(16f))
    borderPainted_=(true)
    action = Action("") {
      for ((value,index) <- controller.getPlayerTurn().zipWithIndex) {
        index match {
          case 1 =>var player = new Player(gui,value,controller);player.top.visible_=(true)
          case default =>
        }
      }
    }
  }
  val player3Button = new Button {
    preferredSize_=(new Dimension(200,100))
    visible_=(false)
    background = color
    foreground_=(Color.WHITE)
    font_=(this.font.deriveFont(16f))
    borderPainted_=(true)
    action = Action("") {
      for ((value,index) <- controller.getPlayerTurn().zipWithIndex) {
        index match {
          case 2 =>var player = new Player(gui,value,controller);player.top.visible_=(true);
          case default =>
        }
      }
    }
  }
  val player4Button = new Button {
    preferredSize_=(new Dimension(200,100))
    visible_=(false)
    background = color
    foreground_=(Color.WHITE)
    font_=(this.font.deriveFont(16f))
    borderPainted_=(true)
    action = Action("") {
      for ((value,index) <- controller.getPlayerTurn().zipWithIndex) {
        index match {
          case 3 =>var player = new Player(gui,value,controller);player.top.visible_=(true)
          case default =>
        }
      }
    }
  }

  def allPlayer = new BorderPanel() {
    layout(buttons) = BorderPanel.Position.North
    background = color
  }
  
  def buttons = new FlowPanel() {
    updateButtons()
    contents += player1Button
    contents += player2Button
    contents += player3Button 
    contents += player4Button
    background = color
  }
  
  def updateButtons() {
    for ((value,index) <- controller.getPlayerTurn().zipWithIndex) {
      index match {
        case 0 if (controller.getBreak(value))=> player1Button.visible_=(true);player1Button.text_=("Player " + value+" - stopped")
        case 0 => player1Button.visible_=(true);player1Button.text_=("Player " + value+" - active")
        case 1 if (controller.getBreak(value)) => player2Button.visible_=(true);player2Button.text_=("Player " + value+" - stopped")
        case 1 => player2Button.visible_=(true);player2Button.text_=("Player " + value+" - active")
        case 2 if (controller.getBreak(value)) => player3Button.visible_=(true);player3Button.text_=("Player " + value+" - stopped")
        case 2 => player3Button.visible_=(true);player3Button.text_=("Player " + value+" - active")
        case 3 if (controller.getBreak(value)) => player4Button.visible_=(true);player4Button.text_=("Player " + value+" - stopped")
        case 3 => player4Button.visible_=(true);player4Button.text_=("Player " + value+" - active")
      }
    }
  }
}