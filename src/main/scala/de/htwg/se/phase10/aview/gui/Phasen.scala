package de.htwg.se.phase10.aview.gui

import swing._
import javax.swing.ImageIcon
import de.htwg.se.phase10.controller.IController
import scala.swing.event.ButtonClicked

class Phasen(gui:createGameField,name:String,controller:IController) extends Frame {
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

  listenTo(card)

  reactions += {
    case ButtonClicked(`card`) if (!gui.willMove && !controller.getMove() && !gui.playerMenu) => gui.willMove = true;gui.move.updateMove; gui.move.top.visible_=(true)
    case ButtonClicked(`card`) if(gui.willMove || gui.playerMenu) =>
    case ButtonClicked(`card`) => gui.infoFeld.turnPhase.text_=("You did this phase already!")
  }
}