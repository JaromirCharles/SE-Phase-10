package de.htwg.se.phase10.model
import scala.collection.mutable.ListBuffer

object help {
  def getMap(l:List[Card]) : collection.mutable.Map[Int,Int] = {
    var map = collection.mutable.Map[Int, Int]()
      for (x <- l) {
        x match {
          case existsNormal:NormalCard if(map.contains(existsNormal.cardtype)) => map.put(existsNormal.cardtype, map.get(existsNormal.cardtype).get + 1) 
          case newNormal:NormalCard if(!map.contains(newNormal.cardtype)) => map.put(newNormal.cardtype, 1)
          case newJoker:SpecialCard if (newJoker.typeCard.equals(CardType.Joker)) => map.put(0, 1)
          case newBreak:SpecialCard if (newBreak.typeCard.equals(CardType.Break)) => map.put(13, 1)
          case existsBreak:SpecialCard if(map.contains(13)) => map.put(13, map.get(13).get + 1)
          case existsJoker:SpecialCard if(map.contains(0)) => map.put(0, map.get(0).get + 1)
        }
      }
    return map;
  }

  def getList(l:List[Card]) : ListBuffer[Int] = {
    var list = new ListBuffer[Int]()
    for (x <- l) {
      x match {
        case normal:NormalCard => list += normal.cardtype
        case special:SpecialCard => list += 0
      }
    }
    return list
  }
  
  def getListC(l:List[Card]) : ListBuffer[String] = {
    var list = new ListBuffer[String]()
    for (x <- l) {
      x match {
        case normal:NormalCard => list += normal.color.toString()
        case special:SpecialCard if (special.typeCard.equals(CardType.Joker))=> list += "Blau"
      }
    }
    return list
  }
}

// 2 Drillinge
object Phase1 extends Phase {
  override def movePhase(moveCards : List[Card]) : (Boolean, collection.mutable.Map[Int, Int]) = {
    var map = collection.mutable.Map[Int, Int]()
    if (moveCards.length < 6) return (false, map);
    map = help.getMap(moveCards)
    if (map.contains(13)) return (false,map)
    return (true, map)
  }
}

//Ein Drilling + eine Viererfolge
object Phase2 extends Phase {
  override def movePhase(moveCards : List[Card]) : (Boolean, collection.mutable.Map[Int, Int], List[Int]) = {
    var map = collection.mutable.Map[Int, Int]()
    var list = new ListBuffer[Int]()
    if (moveCards.length < 7) return (false,map,list.toList)
    map = help.getMap(moveCards)
    if (map.contains(13)) return (false,map,list.toList)
    for (x <- map) {
      if(x._2 < 2 && !x._1.equals(0)) {
        list+=x._1
        map.remove(x._1)
      }
    }
    return (true, map,list.toList.sorted)
  }
}

//Ein Vierling + eine Viererfolge
object Phase3 extends Phase {
  override def movePhase(moveCards : List[Card]) : (Boolean, collection.mutable.Map[Int, Int], List[Int]) = {
    var map = collection.mutable.Map[Int, Int]()
    var list = new ListBuffer[Int]()
    if (moveCards.length < 8) return (false,map,list.toList)
    map = help.getMap(moveCards)
    if (map.contains(13)) return (false,map,list.toList)
    for (x <- map) {
      if(x._2 < 2 && !x._1.equals(0)) {
        list+=x._1
        map.remove(x._1)
      }
    }
    return (true, map,list.toList.sorted)
  }
}

//Eine Siebenerfolge
object Phase4  extends Phase {
  override def movePhase(moveCards : List[Card]) : (Boolean, List[Int]) = {
    var list = new ListBuffer[Int]()
    if (moveCards.length < 7) return (false, list.toList)
    if (moveCards.contains(SpecialCard(CardType.Break))) return (false, list.toList)
    list = help.getList(moveCards)
    return (true, list.toList.sorted)
  }
}

//Eine Achterfolge
object Phase5  extends Phase {
  override def movePhase(moveCards : List[Card]) : (Boolean, List[Int]) = {
    var list = new ListBuffer[Int]()
    if (moveCards.length < 8) return (false, list.toList)
    if (moveCards.contains(SpecialCard(CardType.Break))) return (false, list.toList)
    list = help.getList(moveCards)
    return (true, list.toList.sorted)
  }
}

//Eine Neunerfolge
object Phase6  extends Phase {
  override def movePhase(moveCards : List[Card]) : (Boolean, List[Int]) = {
    var list = new ListBuffer[Int]()
    if (moveCards.length < 9) return (false, list.toList)
    if (moveCards.contains(SpecialCard(CardType.Break))) return (false, list.toList)
    list = help.getList(moveCards)
    return (true, list.toList.sorted)
  }
}

//Zwei Vierlinge
object Phase7 extends Phase {
  override def movePhase(moveCards : List[Card]) : (Boolean, collection.mutable.Map[Int, Int]) = {
    var map = collection.mutable.Map[Int, Int]()
    if (moveCards.length < 8) return (false, map);
    map = help.getMap(moveCards)
    if (map.contains(13)) return (false,map)
    return (true, map)
  }
}

//Sieben Karten eine Farbe
object Phase8 extends Phase {
  override def movePhase(moveCards : List[Card]) : (Boolean, List[String]) = {
    var list = new ListBuffer[String]()
    if (moveCards.length < 7) return (false, list.toList);
    if (moveCards.contains(SpecialCard(CardType.Break))) return (false, list.toList)
    list = help.getListC(moveCards)
    return (true, list.toList)
  }  
}

//Ein Fünfling + ein Zwilling
object Phase9 extends Phase {
  override def movePhase(moveCards : List[Card]) : (Boolean, collection.mutable.Map[Int, Int]) = {
    var map = collection.mutable.Map[Int, Int]()
    if (moveCards.length < 7) return (false, map);
    map = help.getMap(moveCards)
    if (map.contains(13)) return (false,map)
    return (true, map)
  }
}

//Ein Fünfling + ein Drilling
object Phase10 extends Phase {
  override def movePhase(moveCards : List[Card]) : (Boolean, collection.mutable.Map[Int, Int]) = {
    var map = collection.mutable.Map[Int, Int]()
    if (moveCards.length < 8) return (false, map);
    map = help.getMap(moveCards)
    if (map.contains(13)) return (false,map)
    return (true, map)
  }
}

