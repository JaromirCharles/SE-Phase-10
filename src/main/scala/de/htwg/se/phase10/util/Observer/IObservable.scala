package de.htwg.se.phase10.util.Observer

trait IObservable {

  def addObserver(i:IObserver)
  def removeObserver(i:IObserver)
  def removeAllObservers
  def notifyObservers
  def notifyObservers(e:Event)
}