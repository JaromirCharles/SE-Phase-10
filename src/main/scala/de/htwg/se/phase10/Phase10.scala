package de.htwg.se.phase10

import com.google.inject.Guice
import net.codingwell.scalaguice.InjectorExtensions._
import de.htwg.se.phase10.aview.tui.Tui
import de.htwg.se.phase10.aview.gui.MainMenu
import de.htwg.se.phase10.controller.impl.Controller
import de.htwg.se.phase10.aview.gui.MainMenu

trait TraitPhase10

object Phase10 {

  private var phase10:ClassPhase10 =_
  
  private final class ClassPhase10 extends TraitPhase10 {
  
  }
  
  def getInstance(): TraitPhase10 = {
    if (this.phase10 != null)
      this.phase10.asInstanceOf[ClassPhase10]
    else {
      this.phase10 = new ClassPhase10
      return this.phase10
    }
  }

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