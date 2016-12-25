package de.htwg.se.phase10.controller

object GameStatus extends Enumeration  {
  val Welcome, NewGame, NewDeck, NewStack, IllegalMove, NextRound, AddPlayer, ExitGame, RoundOver = Value
}