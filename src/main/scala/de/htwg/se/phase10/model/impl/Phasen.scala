package de.htwg.se.phase10.model.impl

import scala.collection.mutable.ListBuffer


object helperMethods {
  
  def checkSize(cards: List[Card], size:Int) : Boolean = {
    val special:SpecialCard= new SpecialCard(CardType.Break)
    if (cards.size != size || cards.contains(special)) return false
    return true
  }
  
  def checkTwoGroups(cards: List[Card],number:Int) : Boolean = {
    var firstCard = cards(checkJoker(cards,0,number))
    var secondCard = cards(checkJoker(cards,number,number))
    for ((x,i)<-cards.zipWithIndex) {
      var compareCard = cards(i)
      if (i < number) {
        if (!(firstCard.getRank.equals(compareCard.getRank) || compareCard.getRank.equals(CardType.Joker))) return false 
      }
      if (i > number) {
        if (!(secondCard.getRank.equals(compareCard.getRank) || compareCard.getRank.equals(CardType.Joker))) return false 
      }
    }
    return true
  }
  
  def  checkOneGroup(cards: List[Card], number:Int) : Boolean = {
    var firstCard = cards(checkJoker(cards,0,number))
    for ((x,i)<-cards.zipWithIndex) {
      var compareCard = cards(i)
      if (i < number) {
        if (!(firstCard.getRank.equals(compareCard.getRank) || compareCard.getRank.equals(CardType.Joker))) return false 
      }
    }
    var cardsRow = cards.drop(number)
    return checkRow(cardsRow,cardsRow.size)
  }
  
  def checkRow(cards: List[Card],number:Int) : Boolean = {
    var index = checkJoker(cards,0,number)
    var currentCard = cards(index)
    if (!currentCard.isInstanceOf[NormalCard]) return true
    if (currentCard.asInstanceOf[NormalCard].cardtype - index <= 0) return false
    var compareNumber = currentCard.asInstanceOf[NormalCard].cardtype
    for ((x,i)<-cards.zipWithIndex) {
      currentCard = cards(i)
      if (currentCard.isInstanceOf[NormalCard])
        if (compareNumber != currentCard.asInstanceOf[NormalCard].cardtype) return false
      compareNumber += 1
    }
    return true
  }
  
  def checkColor(cards: List[Card], number:Int) : Boolean = {
    var index = checkJoker(cards,0,number)
    var currentCard = cards(index)
    if (!currentCard.isInstanceOf[NormalCard]) return true
    var compareColor = currentCard.asInstanceOf[NormalCard].color
    for ((x,i)<-cards.zipWithIndex) {
      currentCard = cards(i)
      if (currentCard.isInstanceOf[NormalCard])
        if (compareColor != currentCard.asInstanceOf[NormalCard].color) return false
    }
    return true
  }
  
  def checkJoker(cards: List[Card],index: Int,number: Int) : Int  = {
    var in = index
    var currentCard = cards(in)
    var bool = true
    val special:SpecialCard= new SpecialCard(CardType.Joker)
    while (bool && in != number -1) {
      in += 1
      currentCard match {
        case special:SpecialCard => currentCard = cards(in)
        case _ => currentCard = cards(in);bool = false;
      }
    }
    return in
  }
}

object Phase1 extends Phase {
  override def checkPhaseSize(cards : List[Card]) : Boolean = {
    if (helperMethods.checkSize(cards,6)) return helperMethods.checkTwoGroups(cards,3)
    return false
  }
}

object Phase2 extends Phase {
  override def checkPhaseSize(cards: List[Card]) : Boolean = {
    if (helperMethods.checkSize(cards, 7)) return helperMethods.checkOneGroup(cards,3)
    return false
  }
}

object Phase3 extends Phase {
  override def checkPhaseSize(cards: List[Card]) : Boolean = {
    if (helperMethods.checkSize(cards, 8)) return helperMethods.checkOneGroup(cards,4)
    return false
  }
}

object Phase4 extends Phase {
  override def checkPhaseSize(cards: List[Card]) : Boolean = {
    if (helperMethods.checkSize(cards, 7)) return helperMethods.checkRow(cards, 7)
    return false
  }
}

object Phase5 extends Phase {
  override def checkPhaseSize(cards: List[Card]) : Boolean = {
    if (helperMethods.checkSize(cards, 8)) return helperMethods.checkRow(cards, 8)
    return false
  }
}

object Phase6 extends Phase {
  override def checkPhaseSize(cards: List[Card]) : Boolean = {
    if (helperMethods.checkSize(cards, 9)) return helperMethods.checkRow(cards, 9)
    return false
  }
}

object Phase7 extends Phase {
  override def checkPhaseSize(cards : List[Card]) : Boolean = {
    if (helperMethods.checkSize(cards,8)) return helperMethods.checkTwoGroups(cards,4)
    return false
  }
}

object Phase8 extends Phase {
  override def checkPhaseSize(cards : List[Card]) : Boolean = {
    if (helperMethods.checkSize(cards,7)) return helperMethods.checkColor(cards,7)
    return false
  }
}

object Phase9 extends Phase {
  override def checkPhaseSize(cards : List[Card]) : Boolean = {
    if (helperMethods.checkSize(cards,7)) return helperMethods.checkTwoGroups(cards,5)
    return false
  }
}

object Phase10 extends Phase {
  override def checkPhaseSize(cards : List[Card]) : Boolean = {
    if (helperMethods.checkSize(cards,8)) return helperMethods.checkTwoGroups(cards,5)
    return false
  }
}

