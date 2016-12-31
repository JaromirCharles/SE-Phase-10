package de.htwg.se.phase10.aview.gui                                                              

import swing._  
import java.awt.image.BufferedImage                                           
import java.io.File                                                           
import javax.imageio.ImageIO   
import javax.swing.WindowConstants.DISPOSE_ON_CLOSE
import de.htwg.se.phase10.controller.IController
import javafx.stage.Window

class ImagePanel extends Panel                                                
{
  private var _imagePath = ""                                                 
  private var bufferedImage:BufferedImage = null                              

  def imagePath = _imagePath                                                  

  def imagePath_=(value:String)                                               
  {                                                                           
    _imagePath = value                                                        
    bufferedImage = ImageIO.read(new File(_imagePath))                        
  }                                                                           

  override def paintComponent(g:Graphics2D) =                                 
  {     
    val h = bufferedImage.getHeight
    val w = bufferedImage.getWidth
    if (null != bufferedImage) {
        g.drawImage(bufferedImage, 0, 0, w, h, null)  
    }
  } 
  
}                                                                             

object ImagePanel                                                             
{                                                                             
  def apply() = new ImagePanel()                                              
} 

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
    contents = new ImagePanel {
      imagePath = ("./img/Phase10MainMenu.jpeg")
      border = Swing.EmptyBorder(15,15,15,15)
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
class MainMenu(var controller:IController) {
  val imagePanel = new ImagePanelDemo(controller)
  imagePanel.top.pack()
  imagePanel.top.visible_=(true)
}
