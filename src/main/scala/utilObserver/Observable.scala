package utilObserver

class Observable extends IObservable {
  var subscribers:Vector[IObserver] = Vector()
  def addObserver(s:IObserver) = subscribers = subscribers:+s
  def removeObserver(s:IObserver) = subscribers = subscribers.filterNot { o => o == s}
  def removeAllObservers() = subscribers = subscribers.drop(subscribers.size)
  def notifyObservers = subscribers.foreach { o => o.update }
}