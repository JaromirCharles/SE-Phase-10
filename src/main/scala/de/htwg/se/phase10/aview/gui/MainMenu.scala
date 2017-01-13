package de.htwg.se.phase10.aview.gui                                                              

import swing._  
import java.awt.image.BufferedImage                                           
import java.io.File                                                           
import javax.imageio.ImageIO   
import javax.swing.WindowConstants.DISPOSE_ON_CLOSE
import de.htwg.se.phase10.controller.IController
import javafx.stage.Window
import java.awt.Color

class ImagePanelDemo(var controller:IController) extends SimpleSwingApplication {
  
  override def top = new MainFrame {
    title = "Phase 10 Main Menu"
    preferredSize = new Dimension(640,530)
    resizable_=(false)
    menuBar = new MenuBar {
      contents += new Menu("Game Menu") {
        contents += new MenuItem( new Action ("New Game ...") {
          def apply() {
            dispose()
            startGame()
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
        contents += new Button("New Game"){
          this.preferredSize = new Dimension(300,100)
          this.opaque_=(false)
          this.contentAreaFilled_=(false)
          this.borderPainted_=(true)
          this.foreground_=(Color.RED)
          font_=(this.font.deriveFont(30f))
        }
        this.opaque_=(false)
      }
      
      contents += new FlowPanel() {
        contents += new Button("Exit Game"){
          this.preferredSize = new Dimension(300,100)
          this.opaque_=(false)
          this.contentAreaFilled_=(false)
          this.borderPainted_=(true)
          this.foreground_=(Color.RED)
          font_=(this.font.deriveFont(30f))
        }
        this.opaque_=(false)
      }
    }  
  }
  
  def startGame() {
    controller.newGame(true)
    val createPlayer = new CreatePlayer(controller)
    createPlayer.top.visible_=(true)
  }

  def exitMenu(parent:Component) {
    val res = Dialog.showConfirmation(parent, "Do you really want to quit?",
        optionType=Dialog.Options.YesNo,title="Exit Game")
    if (res == Dialog.Result.Yes) sys.exit(0)
    else if (res == Dialog.Result.No) {
      return
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

class MainMenu(var controller:IController) {
  val imagePanel = new ImagePanelDemo(controller)
  imagePanel.top.pack()
  imagePanel.top.visible_=(true)
}
