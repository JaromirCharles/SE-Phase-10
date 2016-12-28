package de.htwg.se.phase10
import de.htwg.se.phase10.aview.tui.Tui2
import de.htwg.se.phase10.controller.impl.Controller

object Phase10 {
  def main(args: Array[String]): Unit = {
   var controller = new Controller()
   
   var boolInput = true
   
   val tui = new Tui2(controller)
   
   //var input = scala.io.StdIn.readLine()
   
   while (boolInput == true) {
     boolInput = tui.inputString(scala.io.StdIn.readLine())
   }
  }
}
