package utilObserver

trait IObservable {
  def addObserver(i:IObserver)
  def removeObserver(i:IObserver)
  def removeAllObservers
  def notifyObservers
}