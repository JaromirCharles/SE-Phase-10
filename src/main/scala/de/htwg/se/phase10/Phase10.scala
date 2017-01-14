package de.htwg.se.phase10

import de.htwg.se.phase10.aview.tui.Tui
import de.htwg.se.phase10.aview.gui.MainMenu
import de.htwg.se.phase10.controller.impl.Controller
import de.htwg.se.phase10.aview.gui.MainMenu

object Phase10 {

  private var controller = new Controller()

  def main(args: Array[String]): Unit = {

    val tui = new Tui(controller)

    val gui = new MainMenu(controller)

    var boolInput = true

    while (boolInput == true) {
      boolInput = tui.inputString(scala.io.StdIn.readLine())
    }
  }
}