package de.htwg.se.phase10.aview.gui

import swing._
import javax.swing.ImageIcon
import de.htwg.se.phase10.controller.IController

class Phasen(controller:IController) extends Frame {
  val color = new Color(0x00592D)
  
  def phasenCard = new FlowPanel() {
    contents += card
    background = color
  }
  
  val card = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.icon_=(new ImageIcon(new ImageIcon("./img/phasen.jpg").getImage().getScaledInstance(100,120, java.awt.Image.SCALE_SMOOTH)))
    this.borderPainted_=(true)
  }
  
}