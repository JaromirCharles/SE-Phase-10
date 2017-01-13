package de.htwg.se.phase10.aview.gui

import swing._
import swing.event._
import de.htwg.se.phase10.controller.IController

class PlayerHand(gui:createGameField, controller:IController) extends Frame {
  val color = new Color(0x00592D)
  
  def cards = new FlowPanel() {
    contents += card1
    contents += card2
    contents += card3
    contents += card4
    contents += card5
    contents += card6
    contents += card7
    contents += card8
    contents += card9
    contents += card10
    contents += card11
    background = color
  }
  
  private val card1 = new Button {
    action = Action("") {
      
    }
    this.preferredSize_=(new Dimension(100,120))
    this.opaque_=(false) 
    this.contentAreaFilled_=(false)
    this.borderPainted_=(true)
  }
  
  private val card2 = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.opaque_=(false)
    this.contentAreaFilled_=(false)
    this.borderPainted_=(true)
  }
  
  private val card3 = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.opaque_=(false)
    this.contentAreaFilled_=(false)
    this.borderPainted_=(true)
  }
  
  private val card4 = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.opaque_=(false)
    this.contentAreaFilled_=(false)
    this.borderPainted_=(true)
  }
  
  private val card5 = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.opaque_=(false)
    this.contentAreaFilled_=(false)
    this.borderPainted_=(true)
  }
  
  private val card6 = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.opaque_=(false)
    this.contentAreaFilled_=(false)
    this.borderPainted_=(true)
  }
  
  private val card7 = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.opaque_=(false)
    this.contentAreaFilled_=(false)
    this.borderPainted_=(true)
  }
  
  private val card8 = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.opaque_=(false)
    this.contentAreaFilled_=(false)
    this.borderPainted_=(true)
  }
  
  private val card9 = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.opaque_=(false)
    this.contentAreaFilled_=(false)
    this.borderPainted_=(true)
  }
  
  private val card10 = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.opaque_=(false)
    this.contentAreaFilled_=(false)
    this.borderPainted_=(true)
  }
  
  private val card11 = new Button {
    this.preferredSize_=(new Dimension(100,120))
    this.opaque_=(false)
    this.contentAreaFilled_=(false)
    this.borderPainted_=(true)
  }
  
  updateHand()
  
  listenTo(card1,card2,card3,card4,card5,card6,card7,card8,card9,card10,card11)
  
  reactions += {
    case ButtonClicked(`card1`) if (controller.getPullCard() && card1.icon != null && !gui.willMove) => controller.dropCardStack(1);updateHand();
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card2`) if (controller.getPullCard() && card2.icon != null && !gui.willMove) => controller.dropCardStack(2);updateHand()
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card3`) if (controller.getPullCard() && card3.icon != null && !gui.willMove) => controller.dropCardStack(3);updateHand()
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card4`) if (controller.getPullCard() && card4.icon != null && !gui.willMove) => controller.dropCardStack(4);updateHand()
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card5`) if (controller.getPullCard() && card5.icon != null && !gui.willMove) => controller.dropCardStack(5);updateHand()
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card6`) if (controller.getPullCard() && card6.icon != null && !gui.willMove) => controller.dropCardStack(6);updateHand()
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card7`) if (controller.getPullCard() && card7.icon != null && !gui.willMove) => controller.dropCardStack(7);updateHand()
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card8`) if (controller.getPullCard() && card8.icon != null && !gui.willMove) => controller.dropCardStack(8);updateHand() 
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card9`) if (controller.getPullCard() && card9.icon != null && !gui.willMove) => controller.dropCardStack(9);updateHand()
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card10`) if (controller.getPullCard() && card10.icon != null && !gui.willMove) => controller.dropCardStack(10);updateHand()
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card11`) if (controller.getPullCard() && card11.icon != null && !gui.willMove) => controller.dropCardStack(11);updateHand()
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(_) => gui.infoFeld.turnPhase.text_=("Not a correct move!")
  }
  
  def updateHand() {
    card1.icon_=(null)
    card2.icon_=(null)
    card3.icon_=(null)
    card4.icon_=(null)
    card5.icon_=(null)
    card6.icon_=(null)
    card7.icon_=(null)
    card8.icon_=(null)
    card9.icon_=(null)
    card10.icon_=(null)
    card11.icon_=(null)
    
    for ((value,index) <- controller.getPlayer().hand.zipWithIndex) {
      index match {
        case 0 => card1.icon_=(value.getIcon)
        case 1 => card2.icon_=(value.getIcon)
        case 2 => card3.icon_=(value.getIcon)
        case 3 => card4.icon_=(value.getIcon)
        case 4 => card5.icon_=(value.getIcon)
        case 5 => card6.icon_=(value.getIcon)
        case 6 => card7.icon_=(value.getIcon)
        case 7 => card8.icon_=(value.getIcon)
        case 8 => card9.icon_=(value.getIcon)
        case 9 => card10.icon_=(value.getIcon)
        case 10 => card11.icon_=(value.getIcon)
      }
    }
  }
}