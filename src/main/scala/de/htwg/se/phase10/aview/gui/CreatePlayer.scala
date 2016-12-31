package de.htwg.se.phase10.aview.gui

import swing._
import java.awt.GridLayout
import de.htwg.se.phase10.controller.IController
import java.awt.Color

class CreatePlayer(var controller:IController) extends SimpleSwingApplication {
  val color = Color.LIGHT_GRAY
  override def top = new MainFrame {
    title = "Create Player"
    preferredSize = new Dimension(640,530)
    resizable_=(false)
    
    val labelPlayer1 = new Label {
      text = "Player name:"
    }
    
    val labelPlayer2 = new Label {
      text = "Player name:"
    }
    
    val labelPlayer3 = new Label {
      text = "Player name:"
    }
    
    val labelPlayer4 = new Label {
      text = "Player name:"
    }
    
    val inputPlayer1 = new TextField {
      text = ""
      horizontalAlignment = Alignment.Right
    }
    
    val inputPlayer2 = new TextField {
      text = ""
      horizontalAlignment = Alignment.Right
    }
    
    val inputPlayer3 = new TextField {
      text = ""
      horizontalAlignment = Alignment.Right
    }
    
    val inputPlayer4 = new TextField {
      text = ""
      horizontalAlignment = Alignment.Right
    }
    
    val createPlayer1Button = new Button {
      action = Action("Create Player") {
        controller.createPlayer(inputPlayer1.text)
        this.enabled_=(false)
        inputPlayer1.editable_=(false)
      }
      this.borderPainted = true
      this.enabled = true
    }
    
    val createPlayer2Button = new Button {
      action = Action("Create Player") {
        controller.createPlayer(inputPlayer2.text)
        this.enabled_=(false)
        inputPlayer2.editable_=(false)
      }
      this.borderPainted = true
      this.enabled = true
    }
    
    val createPlayer3Button = new Button {
      action = Action("Create Player") {
        controller.createPlayer(inputPlayer3.text)
        this.enabled_=(false)
        inputPlayer3.editable_=(false)
      }
      this.borderPainted = true
      this.enabled = true
    }
    
    val createPlayer4Button = new Button {
      action = Action("Create Player") {
        controller.createPlayer(inputPlayer4.text)
        this.enabled_=(false)
        inputPlayer4.editable_=(false)
      }
      
      this.borderPainted = true
      this.enabled = true
    }
    
    val emptyLapel1 = new Label {
      text = "  "
    }
    
        
    val emptyLapel2 = new Label {
      text = "  "
    }
    
    val finishButton = new Button {
      action = Action("Start Game") {
        controller.newGame(false)
        dispose()
        val mainField = new MainField(controller)
      }
      borderPainted = true
      enabled = true
    }
    
    contents = new GridPanel(5,3) {
      border = Swing.EmptyBorder(15,15,15,15)
      background = color
      
      contents += labelPlayer1
      contents += inputPlayer1
      contents += createPlayer1Button
      
      contents += labelPlayer2
      contents += inputPlayer2
      contents += createPlayer2Button
      
      contents += labelPlayer3
      contents += inputPlayer3
      contents += createPlayer3Button
      
      contents += labelPlayer4
      contents += inputPlayer4
      contents += createPlayer4Button
      
      contents += emptyLapel1
      contents += finishButton
      contents += emptyLapel2
    }
    
    menuBar = new MenuBar {
      contents += new Menu("Game Menu") {
        contents += new MenuItem( new Action("Exit Game ...") {
          def apply = exitMenu(menuBar)
        })
      }
    }
    
    def exitMenu(parent:Component) {
      val res = Dialog.showConfirmation(parent, "Do you really want to quit?",
        optionType=Dialog.Options.YesNo,title="Exit Game")
      if (res == Dialog.Result.Yes) {
        controller.quitGame()
        sys.exit(0)
      }
      else if (res == Dialog.Result.No) return
    }
  }
}