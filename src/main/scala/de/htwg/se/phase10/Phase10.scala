package de.htwg.se.phase10

import com.google.inject.Guice
import net.codingwell.scalaguice.InjectorExtensions._
import de.htwg.se.phase10.aview.tui.Tui
import de.htwg.se.phase10.aview.gui.MainMenu
import de.htwg.se.phase10.controller.impl.Controller
import de.htwg.se.phase10.aview.gui.MainMenu

object Phase10 {

  def main(args: Array[String]): Unit = {
  
    val injector = Guice.createInjector(new Phase10Module)
    
    val tui:Tui = injector.instance[Tui]

    val gui:MainMenu = injector.instance[MainMenu]

    var boolInput = true

    while (boolInput == true) {
      boolInput = tui.inputString(scala.io.StdIn.readLine())
    }
  }
}