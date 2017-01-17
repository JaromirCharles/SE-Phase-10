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
    case ButtonClicked(`card1`) if (controller.getPullCard() && card1.icon != null && !gui.willMove && !gui.playerMenu) => controller.dropCardStack(1);updateHand();
                                if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
                                else if (controller.getGameOver()) {} 
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card2`) if (controller.getPullCard() && card2.icon != null && !gui.willMove && !gui.playerMenu) => controller.dropCardStack(2);updateHand();
                                if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
                                else if (controller.getGameOver()) {}   
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card3`) if (controller.getPullCard() && card3.icon != null && !gui.willMove && !gui.playerMenu) => controller.dropCardStack(3);updateHand();
                                if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
                                else if (controller.getGameOver()) {}  
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card4`) if (controller.getPullCard() && card4.icon != null && !gui.willMove && !gui.playerMenu) => controller.dropCardStack(4);updateHand();
                                if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
                                else if (controller.getGameOver()) {}   
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card5`) if (controller.getPullCard() && card5.icon != null && !gui.willMove && !gui.playerMenu) => controller.dropCardStack(5);updateHand();
                                if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
                                else if (controller.getGameOver()) {}   
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card6`) if (controller.getPullCard() && card6.icon != null && !gui.willMove && !gui.playerMenu) => controller.dropCardStack(6);updateHand();
                                if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
                                else if (controller.getGameOver()){}    
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card7`) if (controller.getPullCard() && card7.icon != null && !gui.willMove && !gui.playerMenu) => controller.dropCardStack(7);updateHand();
                                if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
                                else if (controller.getGameOver()){}    
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card8`) if (controller.getPullCard() && card8.icon != null && !gui.willMove && !gui.playerMenu) => controller.dropCardStack(8);updateHand();
                                if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
                                else if (controller.getGameOver()) {}   
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card9`) if (controller.getPullCard() && card9.icon != null && !gui.willMove && !gui.playerMenu) => controller.dropCardStack(9);updateHand();
                                if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
                                else if (controller.getGameOver()) {}  
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card10`) if (controller.getPullCard() && card10.icon != null && !gui.willMove && !gui.playerMenu) => controller.dropCardStack(10);updateHand();
                                if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
                                else if (controller.getGameOver()) {}   
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()
    case ButtonClicked(`card11`) if (controller.getPullCard() && card11.icon != null && !gui.willMove && !gui.playerMenu) => controller.dropCardStack(11);updateHand();
                                if (controller.getRoundOver()) {gui.infoFeld.turnPhase.text_=("New Round begins ...");controller.startNewRound()}
                                else if (controller.getGameOver()) {} 
                                controller.setPlayerNumber();controller.notifyObservers;updateHand()

    case ButtonClicked(`card1`) if (card1.icon != null && gui.willMove && gui.move.checkMoveList) => controller.addToMoveList(1);updateHand();gui.move.updateMove;controller.notifyObservers
    case ButtonClicked(`card2`) if (card2.icon != null && gui.willMove && gui.move.checkMoveList) => controller.addToMoveList(2);updateHand();gui.move.updateMove;controller.notifyObservers
    case ButtonClicked(`card3`) if (card3.icon != null && gui.willMove && gui.move.checkMoveList) => controller.addToMoveList(3);updateHand();gui.move.updateMove;controller.notifyObservers
    case ButtonClicked(`card4`) if (card4.icon != null && gui.willMove && gui.move.checkMoveList) => controller.addToMoveList(4);updateHand();gui.move.updateMove;controller.notifyObservers
    case ButtonClicked(`card5`) if (card5.icon != null && gui.willMove && gui.move.checkMoveList) => controller.addToMoveList(5);updateHand();gui.move.updateMove;controller.notifyObservers
    case ButtonClicked(`card6`) if (card6.icon != null && gui.willMove && gui.move.checkMoveList) => controller.addToMoveList(6);updateHand();gui.move.updateMove;controller.notifyObservers
    case ButtonClicked(`card7`) if (card7.icon != null && gui.willMove && gui.move.checkMoveList) => controller.addToMoveList(7);updateHand();gui.move.updateMove;controller.notifyObservers
    case ButtonClicked(`card8`) if (card8.icon != null && gui.willMove && gui.move.checkMoveList) => controller.addToMoveList(8);updateHand();gui.move.updateMove;controller.notifyObservers
    case ButtonClicked(`card9`) if (card9.icon != null && gui.willMove && gui.move.checkMoveList) => controller.addToMoveList(9);updateHand();gui.move.updateMove;controller.notifyObservers
    case ButtonClicked(`card10`) if (card10.icon != null && gui.willMove && gui.move.checkMoveList) => controller.addToMoveList(10);updateHand();gui.move.updateMove;controller.notifyObservers 
    case ButtonClicked(`card11`) if (card11.icon != null && gui.willMove && gui.move.checkMoveList) => controller.addToMoveList(11);updateHand();gui.move.updateMove;controller.notifyObservers   
    
    case ButtonClicked(`card1`) if (card1.icon != null && gui.willAddLeft) => if (controller.addCardToList(gui.playerIndex, 1, 1)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!")}
    case ButtonClicked(`card2`) if (card2.icon != null && gui.willAddLeft) => if (controller.addCardToList(gui.playerIndex, 2, 1)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!")}
    case ButtonClicked(`card3`) if (card3.icon != null && gui.willAddLeft) => if (controller.addCardToList(gui.playerIndex, 3, 1)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!")}
    case ButtonClicked(`card4`) if (card4.icon != null && gui.willAddLeft) => if (controller.addCardToList(gui.playerIndex, 4, 1)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card5`) if (card5.icon != null && gui.willAddLeft) => if (controller.addCardToList(gui.playerIndex, 5, 1)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card6`) if (card6.icon != null && gui.willAddLeft) => if (controller.addCardToList(gui.playerIndex, 6, 1)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card7`) if (card7.icon != null && gui.willAddLeft) => if (controller.addCardToList(gui.playerIndex, 7, 1)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card8`) if (card8.icon != null && gui.willAddLeft) => if (controller.addCardToList(gui.playerIndex, 8, 1)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card9`) if (card9.icon != null && gui.willAddLeft) => if (controller.addCardToList(gui.playerIndex, 9, 1)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card10`) if (card10.icon != null && gui.willAddLeft) => if (controller.addCardToList(gui.playerIndex, 10, 1)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card11`) if (card11.icon != null && gui.willAddLeft) => if (controller.addCardToList(gui.playerIndex, 11, 1)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
      
    case ButtonClicked(`card1`) if (card1.icon != null && gui.willAddRight) => if (controller.addCardToList(gui.playerIndex, 1, 2)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card2`) if (card2.icon != null && gui.willAddRight) => if (controller.addCardToList(gui.playerIndex, 2, 2)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card3`) if (card3.icon != null && gui.willAddRight) => if (controller.addCardToList(gui.playerIndex, 3, 2)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card4`) if (card4.icon != null && gui.willAddRight) => if (controller.addCardToList(gui.playerIndex, 4, 2)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card5`) if (card5.icon != null && gui.willAddRight) => if (controller.addCardToList(gui.playerIndex, 5, 2)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card6`) if (card6.icon != null && gui.willAddRight) => if (controller.addCardToList(gui.playerIndex, 6, 2)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card7`) if (card7.icon != null && gui.willAddRight) => if (controller.addCardToList(gui.playerIndex, 7, 2)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card8`) if (card8.icon != null && gui.willAddRight) => if (controller.addCardToList(gui.playerIndex, 8, 2)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card9`) if (card9.icon != null && gui.willAddRight) => if (controller.addCardToList(gui.playerIndex, 9, 2)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card10`) if (card10.icon != null && gui.willAddRight) => if (controller.addCardToList(gui.playerIndex, 10, 2)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    case ButtonClicked(`card11`) if (card11.icon != null && gui.willAddRight) => if (controller.addCardToList(gui.playerIndex, 11, 2)) {updateHand();gui.infoFeld.turnPhase.text_=("Card added!");gui.player.player.closeFrame()} 
        else {gui.infoFeld.turnPhase.text_=("Not a correct card!");gui.player.player.closeFrame()}
    
    case ButtonClicked(_) if (gui.willMove && !gui.move.checkMoveList) => gui.infoFeld.turnPhase.text_=("Move list is full!")
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