package de.htwg.se.phase10.aview.gui

import swing._
import de.htwg.se.phase10.controller.IController
import java.awt.Color

class GameInformation (controller:IController) extends Frame {
  val color = new Color(0x00592D)
  def infoText = new FlowPanel() {
    contents += turnPhase
    background = color
  }

  val turnPhase = new TextArea("Its your turn " + controller.getName() +"\nYour current Phase: " + controller.getPhaseNameNumber()._1) {
    foreground_=(Color.WHITE)
    font_=(this.font.deriveFont(16f))
    preferredSize_=(new Dimension(400,100))
    editable_=(false)
    border = Swing.EmptyBorder(15, 15, 15, 15)
    background = color
  }
}