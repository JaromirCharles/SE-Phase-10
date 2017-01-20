package de.htwg.se.phase10.util.Observer
import scala.Vector

class Observable extends IObservable {

  var subscribers:Vector[IObserver] = Vector()
  def addObserver(s:IObserver) = subscribers = subscribers:+s
  def removeObserver(s:IObserver) = subscribers = subscribers.filterNot { o => o == s}
  def removeAllObservers = subscribers = subscribers.drop(subscribers.size)
  def notifyObservers = notifyObservers(null)
  def notifyObservers(e:Event) = subscribers.foreach { o => o.update(e) }
} 

