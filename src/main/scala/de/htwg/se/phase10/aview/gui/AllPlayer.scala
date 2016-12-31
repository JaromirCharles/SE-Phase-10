package de.htwg.se.phase10.aview.gui

import swing._
import java.awt.Color
import de.htwg.se.phase10.controller.IController

class AllPlayer(controller:IController) extends Frame {
  val color = new Color(0x00592D)
  val player1Button = new Button {
    this.preferredSize_=(new Dimension(100,120)) 
  }
  val player2Button = new Button {
    this.preferredSize_=(new Dimension(100,120))
  }
  val player3Button = new Button {
    this.preferredSize_=(new Dimension(100,120))
  }
  val player4Button = new Button {
    this.preferredSize_=(new Dimension(100,120))
  }
  
  def allPlayer = new BorderPanel() {
    layout(buttons) = BorderPanel.Position.North
    background = color
  }
  
  def buttons = new FlowPanel() {
    for ((value,index) <- controller.getPlayerTurn().zipWithIndex) {
      index match {
        case 0 => player1Button.visible_=(true);player1Button.text_=("Player " + value);contents += player1Button
        case 1 => player2Button.visible_=(true);player2Button.text_=("Player " + value);contents += player2Button
        case 2 => player3Button.visible_=(true);player3Button.text_=("Player " + value);contents += player3Button
        case 3 => player4Button.visible_=(true);player4Button.text_=("Player " + value);contents += player4Button
      }
    }
    background = color
  } 
}