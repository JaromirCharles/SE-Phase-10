package de.htwg.se.phase10.controller

object GameStatus extends Enumeration  {
  val Welcome, NewGame, NewDeck, NewStack, UpdateStack, IllegalMove, NextRound, AddPlayer, ExitGame, RoundOver, GameOver = Value
}