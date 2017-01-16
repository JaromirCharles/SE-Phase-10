package de.htwg.se.phase10.aview.gui                                                              

import swing._  
import java.awt.image.BufferedImage                                           
import java.io.File                                                           
import javax.imageio.ImageIO   
import javax.swing.WindowConstants.DISPOSE_ON_CLOSE
import de.htwg.se.phase10.util.Observer.IObserver
import de.htwg.se.phase10.util.Observer.Event
import de.htwg.se.phase10.controller.IController
import de.htwg.se.phase10.controller.StartGame
import de.htwg.se.phase10.controller.ExitGame
import javafx.stage.Window
import java.awt.Color
import javax.inject.Inject

class ImagePanelDemo(var controller:IController) extends SimpleSwingApplication  with IObserver {

  controller.addObserver(this)

  val mainMenu = new MainFrame {
    title = "Phase 10 Main Menu"
    preferredSize = new Dimension(640,530)
    resizable_=(false)
    menuBar = new MenuBar {
      contents += new Menu("Game Menu") {
        contents += new MenuItem( new Action ("New Game ...") {
          def apply() {
            startGame
          }
        })
        contents += new MenuItem( new Action("Exit Game ...") {
          def apply = exitMenu(menuBar)
        })
      }
    }
    contents = new ImagePanel(2,1) {
      imagePath = ("./img/Phase10MainMenu.jpeg")
      border = Swing.EmptyBorder(15,15,15,15)
      contents += new FlowPanel() {
        contents += new Button {
          preferredSize = new Dimension(300,100)
          opaque_=(false)
          contentAreaFilled_=(false)
          borderPainted_=(true)
          foreground_=(Color.RED)
          font_=(this.font.deriveFont(30f))
          action = Action("New Game") {
            startGame
          }
        }
        opaque_=(false)
      }

      contents += new FlowPanel() {
        contents += new Button {
          this.preferredSize = new Dimension(300,100)
          this.opaque_=(false)
          this.contentAreaFilled_=(false)
          this.borderPainted_=(true)
          this.foreground_=(Color.RED)
          font_=(this.font.deriveFont(30f))
          action = Action("Exit Game") {
            exitMenu(menuBar)
          }
        }
        this.opaque_=(false)
      }
    }
  }

  override def top = mainMenu

  def startGame = controller.newGame(true)

  def exitMenu(parent:Component) {
    val res = Dialog.showConfirmation(parent, "Do you really want to quit?",
        optionType=Dialog.Options.YesNo,title="Exit Game")
    if (res == Dialog.Result.Yes) {
      controller.notifyObservers(new ExitGame)
      sys.exit(0)
    }
    else if (res == Dialog.Result.No) {
      return
    }
  }

   override def update(e:Event) {
    if (e.isInstanceOf[StartGame]) {
      mainMenu.dispose()
      val createPlayer = new CreatePlayer(controller)
      createPlayer.top.visible_=(true)
    }
  }
}

class ImagePanel(rows0: Int, cols0: Int) extends GridPanel(rows0, cols0) {

  private var _imagePath = ""                                                
  private var buf = Option.empty[BufferedImage]

  def imagePath = _imagePath

  def imagePath_=(value: String): Unit = {
    _imagePath = value
    buf.foreach(_.flush()); buf = None
    buf = Some(ImageIO.read(new File(value)))
    repaint()
  }

  override def paintComponent(g: Graphics2D): Unit = {
    super.paintComponent(g)
    buf.foreach(g.drawImage(_, 0, 0, null))
  }
}

class MainMenu @Inject() (var controller:IController) {
  val imagePanel = new ImagePanelDemo(controller)
  imagePanel.top.pack()
  imagePanel.top.visible_=(true)
}