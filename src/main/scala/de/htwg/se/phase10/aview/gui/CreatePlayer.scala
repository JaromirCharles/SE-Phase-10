package de.htwg.se.phase10.aview.gui

import swing._
import java.awt.GridLayout
import de.htwg.se.phase10.util.Observer.IObserver
import de.htwg.se.phase10.util.Observer.Event
import de.htwg.se.phase10.controller.IController
import de.htwg.se.phase10.controller.AddPlayer
import java.awt.Color

class CreatePlayer(var controller:IController) extends SimpleSwingApplication with IObserver {
  
  controller.addObserver(this)
  
  val color = new Color(0x00592D)
  var numberPlayer = 0

  var createPlayer = new MainFrame {
    title = "Create Player"
    preferredSize = new Dimension(640,530)
    resizable_=(false)

    val labelPlayer1 = new Label {
      text = "Player name:"
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      border = Swing.EmptyBorder(15, 15, 15, 15)
    }

    val labelPlayer2 = new Label {
      text = "Player name:"
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      border = Swing.EmptyBorder(15, 15, 15, 15)
    }

    val labelPlayer3 = new Label {
      text = "Player name:"
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      border = Swing.EmptyBorder(15, 15, 15, 15)
    }

    val labelPlayer4 = new Label {
      text = "Player name:"
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      border = Swing.EmptyBorder(15, 15, 15, 15)
    }

    val inputPlayer1 = new TextField {
      text = ""
      horizontalAlignment = Alignment.Right
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      border = Swing.EmptyBorder(15, 15, 15, 15)
    }

    val inputPlayer2 = new TextField {
      text = ""
      horizontalAlignment = Alignment.Right
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      border = Swing.EmptyBorder(15, 15, 15, 15)
    }

    val inputPlayer3 = new TextField {
      text = ""
      horizontalAlignment = Alignment.Right
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      border = Swing.EmptyBorder(15, 15, 15, 15)
    }

    val inputPlayer4 = new TextField {
      text = ""
      horizontalAlignment = Alignment.Right
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      border = Swing.EmptyBorder(15, 15, 15, 15)
    }

    val createPlayer1Button = new Button {
      action = Action("Create Player") {
        numberPlayer += 1
        if (numberPlayer >= 2 && controller.getNumberAllPlayer == 0) {
          finishButton.enabled_=(true)
        }
        controller.createPlayer(inputPlayer1.text)
        this.enabled_=(false)
        inputPlayer1.editable_=(false)
      }
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      borderPainted = true
      enabled = true
    }
    
    val createPlayer2Button = new Button {
      action = Action("Create Player") {
        numberPlayer += 1
        if (numberPlayer >= 2 && controller.getNumberAllPlayer == 0) {
          finishButton.enabled_=(true)
        }
        controller.createPlayer(inputPlayer2.text)
        this.enabled_=(false)
        inputPlayer2.editable_=(false)
      }
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      borderPainted = true
      enabled = true
    }

    val createPlayer3Button = new Button {
      action = Action("Create Player") {
        numberPlayer += 1
        if (numberPlayer >= 2 && controller.getNumberAllPlayer == 0) {
          finishButton.enabled_=(true)
        }
        controller.createPlayer(inputPlayer3.text)
        this.enabled_=(false)
        inputPlayer3.editable_=(false)
      }
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      borderPainted = true
      enabled = true
    }

    val createPlayer4Button = new Button {
      action = Action("Create Player") {
        numberPlayer += 1
        if (numberPlayer >= 2 && controller.getNumberAllPlayer == 0) {
          finishButton.enabled_=(true)
        }
        controller.createPlayer(inputPlayer4.text)
        this.enabled_=(false)
        inputPlayer4.editable_=(false)
      }
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      borderPainted = true
      enabled = true
    }

    val emptyLapel1 = new Label {
      text = "  "
    }

    val emptyLapel2 = new Label {
      text = "  "
    }

    val finishButton = new Button {
      action = Action("Start Game") {
        startGame
      }
      background = color
      foreground_=(Color.WHITE)
      font_=(this.font.deriveFont(16f))
      borderPainted = true
      enabled = false
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
  }

  def startGame() {
    controller.newGame(false)
    createPlayer.dispose()
    val mainField = new MainField(controller)
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

  override def top = createPlayer

    override def update(e:Event) {
      if (e.isInstanceOf[AddPlayer]) {
        numberPlayer += 1
        if (numberPlayer >= 2 && numberPlayer == controller.getNumberAllPlayer) {
          startGame
        }
      }
    }
}