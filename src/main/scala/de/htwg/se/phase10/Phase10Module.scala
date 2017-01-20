package de.htwg.se.phase10

import com.google.inject.{AbstractModule, PrivateModule}
import net.codingwell.scalaguice.{ScalaModule, ScalaPrivateModule}
import de.htwg.se.phase10.controller.IController
import de.htwg.se.phase10.controller.impl.Controller
import de.htwg.se.phase10.model.IDeck
import de.htwg.se.phase10.model.impl.Deck
import de.htwg.se.phase10.model.IStack
import de.htwg.se.phase10.model.impl.Stack
import de.htwg.se.phase10.model.IPlayerList
import de.htwg.se.phase10.model.impl.PlayerList

class Phase10Module extends AbstractModule with ScalaModule{
 
  override def configure(): Unit = {
    bind[IController].to[Controller]
    bind[IDeck].to[Deck]
    bind[IStack].to[Stack]
    bind[IPlayerList].to[PlayerList]
  }
}

