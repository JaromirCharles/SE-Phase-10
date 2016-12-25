package de.htwg.se.phase10.controller

import de.htwg.se.phase10.util.Observer.IObservable

trait IController extends IObservable{
  
  //Number of Player 
  def checkAnzPlayer(number : Int)
  
  //Create a new Player and adds him\her to playerList
  def createPlayer(name:String)
  
  //returns all Players as String
  def getPlayerList()
  
  //gives every Player 10 hand cards
  def givePlayerHandCards()
}