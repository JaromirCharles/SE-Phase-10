package de.htwg.se.phase10.model.impl

import org.scalatest.WordSpec
import org.scalatest.Matchers._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PhasenSpec extends WordSpec {
  
  "The helperMethod checkSize" should {
    val helper = helperMethods
    "return true for size" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
      helper.checkSize(cardList, 6) should be(true)
    }
    "return false " in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Break),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
      helper.checkSize(cardList, 6) should be(false)
    }
    "return size false " in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
      helper.checkSize(cardList, 6) should be(false)
    }
  }
  
  "The helperMethod checkTwoGroups" should {
    val helper = helperMethods
    "return true for" in {
       var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
       helper.checkTwoGroups(cardList, 3) should be(true)
    }
    
    "return true for joker first place" in {
      var cardList = List(SpecialCard(CardType.Joker),NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
      helper.checkTwoGroups(cardList, 3) should be(true)
    }
    
    "return false for first drilling" in {
      var cardList = List(NormalCard(Colors.Yellow, 11),NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
      helper.checkTwoGroups(cardList, 3) should be(false)
    }
    
    "return false for second drilling" in {
      var cardList = List(NormalCard(Colors.Yellow, 10),NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),NormalCard(Colors.Green, 12),
          SpecialCard(CardType.Joker),NormalCard(Colors.Purple,9))
      helper.checkTwoGroups(cardList, 3) should be(false)
    }
  }
  
  "The helperMethod checkOneGroup" should {
    val helper = helperMethods
    
    "return true" in {
       var cardList = List(NormalCard(Colors.Yellow, 10),NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),NormalCard(Colors.Green, 6),
          NormalCard(Colors.Red,7),NormalCard(Colors.Purple,8),NormalCard(Colors.Purple,9))
       helper.checkOneGroup(cardList, 3) should be(true)
    }
    
    "return falses" in {
       var cardList = List(NormalCard(Colors.Yellow, 10),NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),NormalCard(Colors.Green, 6),
          NormalCard(Colors.Red,8),NormalCard(Colors.Purple,8),NormalCard(Colors.Purple,9))
       helper.checkOneGroup(cardList, 3) should be(false)
    }
    
    "return false cause group" in {
       var cardList = List(NormalCard(Colors.Yellow, 11),NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),NormalCard(Colors.Green, 6),
          NormalCard(Colors.Red,7),NormalCard(Colors.Purple,8),NormalCard(Colors.Purple,9))
       helper.checkOneGroup(cardList, 3) should be(false)
    }
    
    "return false joker cause group" in {
       var cardList = List(NormalCard(Colors.Yellow, 11),SpecialCard(CardType.Joker),NormalCard(Colors.Yellow,10),NormalCard(Colors.Green, 6),
          NormalCard(Colors.Red,7),NormalCard(Colors.Purple,8),NormalCard(Colors.Purple,9))
       helper.checkOneGroup(cardList, 3) should be(false)
    }
  }
  
  "The helperMethod checkRow" should {
    val helper = helperMethods
    
    "return true" in {
      var cardList = List(NormalCard(Colors.Yellow, 1),SpecialCard(CardType.Joker),NormalCard(Colors.Yellow,3),NormalCard(Colors.Green, 4),
          NormalCard(Colors.Red,5),NormalCard(Colors.Purple,6),NormalCard(Colors.Purple,7))
      helper.checkRow(cardList, 7) should be(true)
    }
    
    "return false" in {
      var cardList = List(NormalCard(Colors.Yellow, 2),SpecialCard(CardType.Joker),NormalCard(Colors.Yellow,3),NormalCard(Colors.Green, 4),
          NormalCard(Colors.Red,5),NormalCard(Colors.Purple,6),NormalCard(Colors.Purple,7))
      helper.checkRow(cardList, 7) should be(false)
    }
    
    "return true for only joker" in {
      var cardList = List(SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker))
      helper.checkRow(cardList, 4) should be(true)
    }
    
    "return false for wrong joker use" in {
      var cardList = List(SpecialCard(CardType.Joker),NormalCard(Colors.Yellow, 1),SpecialCard(CardType.Joker),NormalCard(Colors.Yellow,3))
      helper.checkRow(cardList, 4) should be(false)
    }
  }
  
  "The helperMethod checkColor" should {
    val helper = helperMethods
  
    "should be true" in {
      var cardList = List(NormalCard(Colors.Green, 10),NormalCard(Colors.Green, 1),NormalCard(Colors.Green, 11),NormalCard(Colors.Green, 10))
      helper.checkColor(cardList, 4) should be(true)
    }
    
    "should be false" in {
      var cardList = List(NormalCard(Colors.Yellow, 10),NormalCard(Colors.Green, 1),NormalCard(Colors.Green, 11),NormalCard(Colors.Green, 10))
      helper.checkColor(cardList, 4) should be(false)
    }
    
    "should also be false" in {
      var cardList = List(NormalCard(Colors.Green, 10),NormalCard(Colors.Red, 1),NormalCard(Colors.Purple, 11),NormalCard(Colors.Green, 10))
      helper.checkColor(cardList, 4) should be(false)
    }
    
     "should also be again false " in {
      var cardList = List(NormalCard(Colors.Purple, 10),NormalCard(Colors.Yellow, 1),NormalCard(Colors.Purple, 11),NormalCard(Colors.Green, 10))
      helper.checkColor(cardList, 4) should be(false)
    }
    
    "should with joker be false" in {
      var cardList = List(NormalCard(Colors.Green, 10),SpecialCard(CardType.Joker),NormalCard(Colors.Purple, 11),NormalCard(Colors.Green, 10))
      helper.checkColor(cardList, 4) should be(false)
    }
    
    "should be true for only jokers" in {
      var cardList = List(SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker))
        helper.checkColor(cardList, 4) should be(true)
    }
    
    "should be false with joker color" in {
      var cardList = List(SpecialCard(CardType.Joker),NormalCard(Colors.Red, 1),NormalCard(Colors.Red, 2),SpecialCard(CardType.Joker),NormalCard(Colors.Green, 1))
        helper.checkColor(cardList, 5) should be(false)
    }
    
    "should be false with break color" in {
      var cardList = List(SpecialCard(CardType.Joker),NormalCard(Colors.Red, 1),NormalCard(Colors.Red, 2),SpecialCard(CardType.Break),NormalCard(Colors.Green, 1))
        helper.checkColor(cardList, 5) should be(false)
    }
  }
  
  "Phase 1" should {
    val phase1 = Phase1
    
    "be true" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
      phase1.checkPhaseSize(cardList) should be(true)
    }
    
    "be false wrong size" in {
      var cardList = List(NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
      phase1.checkPhaseSize(cardList) should be(false)
    }
    
    "be false" in {
      var cardList = List(NormalCard(Colors.Green,11),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
      phase1.checkPhaseSize(cardList) should be(false)
    }
  }
  
  "Phase 2" should {
    val phase2 = Phase2
    
    "be true" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),NormalCard(Colors.Green,9),
          SpecialCard(CardType.Joker),NormalCard(Colors.Red,11),NormalCard(Colors.Purple,12))
      phase2.checkPhaseSize(cardList) should be(true)
    }
    
    "be false wrong size" in {
      var cardList = List(NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),NormalCard(Colors.Green,9),
          SpecialCard(CardType.Joker),NormalCard(Colors.Red,11),NormalCard(Colors.Purple,12))
      phase2.checkPhaseSize(cardList) should be(false)
    }
    
    "be false" in {
      var cardList = List(NormalCard(Colors.Green,11),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),NormalCard(Colors.Green,9),
          SpecialCard(CardType.Joker),NormalCard(Colors.Red,11),NormalCard(Colors.Purple,12))
      phase2.checkPhaseSize(cardList) should be(false)
    }
  }
         
  "Phase 3" should {
    val phase3 = Phase3
    
    "be true" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),NormalCard(Colors.Green,9),
          SpecialCard(CardType.Joker),NormalCard(Colors.Red,11),NormalCard(Colors.Purple,12))
      phase3.checkPhaseSize(cardList) should be(true)
    }
    
    "be false wrong size" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),NormalCard(Colors.Green,9),
          SpecialCard(CardType.Joker),NormalCard(Colors.Red,11),NormalCard(Colors.Purple,12))
      phase3.checkPhaseSize(cardList) should be(false)
    }
    
    "be false" in {
      var cardList = List(NormalCard(Colors.Green,12),NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),NormalCard(Colors.Green,9),
          SpecialCard(CardType.Joker),NormalCard(Colors.Red,11),NormalCard(Colors.Purple,12))
      phase3.checkPhaseSize(cardList) should be(false)
    }
  }
      
  "Phase 4" should {
    val phase4 = Phase4
    
    "be true" in {
      var cardList = List(NormalCard(Colors.Green,1),NormalCard(Colors.Yellow,2),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,5),NormalCard(Colors.Purple,6),NormalCard(Colors.Purple,7))
      phase4.checkPhaseSize(cardList) should be(true)
    }
    
    "be false wrong size" in {
      var cardList = List(NormalCard(Colors.Yellow,2),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,5),NormalCard(Colors.Purple,6),NormalCard(Colors.Purple,7))
      phase4.checkPhaseSize(cardList) should be(false)
    }
    
    "be false" in {
      var cardList = List(NormalCard(Colors.Green,2),NormalCard(Colors.Yellow,2),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,5),NormalCard(Colors.Purple,6),NormalCard(Colors.Purple,7))
      phase4.checkPhaseSize(cardList) should be(false)
    }
  }
        
  "Phase 5" should {
    val phase5 = Phase5
    
    "be true" in {
      var cardList = List(NormalCard(Colors.Green,1),NormalCard(Colors.Yellow,2),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,5),NormalCard(Colors.Purple,6),NormalCard(Colors.Purple,7),NormalCard(Colors.Purple,8))
      phase5.checkPhaseSize(cardList) should be(true)
    }
    
    "be false wrong size" in {
      var cardList = List(NormalCard(Colors.Yellow,2),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,5),NormalCard(Colors.Purple,6),NormalCard(Colors.Purple,7),NormalCard(Colors.Purple,8))
      phase5.checkPhaseSize(cardList) should be(false)
    }
    
    "be false" in {
      var cardList = List(NormalCard(Colors.Green,2),NormalCard(Colors.Yellow,2),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,5),NormalCard(Colors.Purple,6),NormalCard(Colors.Purple,7),NormalCard(Colors.Purple,8))
      phase5.checkPhaseSize(cardList) should be(false)
    }
  }  
  
  "Phase 6" should {
    val phase6 = Phase6
    
    "be true" in {
      var cardList = List(NormalCard(Colors.Green,1),NormalCard(Colors.Yellow,2),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,5),NormalCard(Colors.Purple,6),NormalCard(Colors.Purple,7),NormalCard(Colors.Purple,8),NormalCard(Colors.Purple,9))
      phase6.checkPhaseSize(cardList) should be(true)
    }
    
    "be false wrong size" in {
      var cardList = List(NormalCard(Colors.Yellow,2),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,5),NormalCard(Colors.Purple,6),NormalCard(Colors.Purple,7),NormalCard(Colors.Purple,8),NormalCard(Colors.Purple,9))
      phase6.checkPhaseSize(cardList) should be(false)
    }
    
    "be false" in {
      var cardList = List(NormalCard(Colors.Green,2),NormalCard(Colors.Yellow,2),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,5),NormalCard(Colors.Purple,6),NormalCard(Colors.Purple,7),NormalCard(Colors.Purple,8),NormalCard(Colors.Purple,9))
      phase6.checkPhaseSize(cardList) should be(false)
    }
  }
 
  "Phase 7" should {
    val phase7 = Phase7
    
    "be true" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9),NormalCard(Colors.Purple,9))
      phase7.checkPhaseSize(cardList) should be(true)
    }
    
    "be false wrong size" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Purple,9),NormalCard(Colors.Purple,9))
      phase7.checkPhaseSize(cardList) should be(false)
    }
    
    "be false" in {
    var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Green,11),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9),NormalCard(Colors.Purple,9))
      phase7.checkPhaseSize(cardList) should be(false)
    }
  }
  
  "Phase 8" should {
    val phase8 = Phase8
    
    "be true" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Green,10),NormalCard(Colors.Green,11),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Green,9),NormalCard(Colors.Green,1))
      phase8.checkPhaseSize(cardList) should be(true)
    }
    
    "be false wrong size" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Green,11),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Green,9),NormalCard(Colors.Green,1))
      phase8.checkPhaseSize(cardList) should be(false)
    }
    
    "be false" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Green,10),NormalCard(Colors.Red,11),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Green,9),NormalCard(Colors.Green,1))
      phase8.checkPhaseSize(cardList) should be(false)
    }
  }
  
  "Phase 9" should {
    val phase9 = Phase9
    
    "be true" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Yellow,10),NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
      phase9.checkPhaseSize(cardList) should be(true)
    }
    
    "be false wrong size" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
      phase9.checkPhaseSize(cardList) should be(false)
    }
    
    "be false" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Yellow,10),NormalCard(Colors.Red,10),NormalCard(Colors.Purple,9))
      phase9.checkPhaseSize(cardList) should be(false)
    }
    
  "Phase 10" should {
    val phase10 = Phase10
    
    "be true" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Yellow,10),NormalCard(Colors.Red,9),NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9))
      phase10.checkPhaseSize(cardList) should be(true)
    }
    
    "be false wrong size" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Red,9),NormalCard(Colors.Purple,9),NormalCard(Colors.Red,9))
      phase10.checkPhaseSize(cardList) should be(false)
    }
    
    "be false" in {
      var cardList = List(NormalCard(Colors.Green,10),NormalCard(Colors.Yellow,10),SpecialCard(CardType.Joker),SpecialCard(CardType.Joker),
          NormalCard(Colors.Yellow,10),NormalCard(Colors.Red,10),NormalCard(Colors.Purple,9),NormalCard(Colors.Red,9))
      phase10.checkPhaseSize(cardList) should be(false)
    }
  }
  }
}
                                                                                
                                                                                       
                                                                                          
                                                                                      
                                                                                      
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                      
                                                                                    
                                                                                      
                                                                                        
                                                                                
                                                                                    
                                                                                  
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                  
                                                                                      
                                                                                      
                                                                                    
                                                                                        
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                  
                                                                                      
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                    
                                                                                
                                                                                
                                                                                       
                                                                                          
                                                                                      
                                                                                      
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                      
                                                                                    
                                                                                      
                                                                                        
                                                                                
                                                                                    
                                                                                  
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                  
                                                                                      
                                                                                      
                                                                                    
                                                                                        
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                  
                                                                                      
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                    
                                                                                
                                                                                
                                                                                       
                                                                                          
                                                                                      
                                                                                      
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                      
                                                                                    
                                                                                      
                                                                                        
                                                                                
                                                                                    
                                                                                  
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                  
                                                                                      
                                                                                      
                                                                                    
                                                                                        
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                  
                                                                                      
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                    
                                                                                
                                                                                
                                                                                
                                                                                       
                                                                                          
                                                                                      
                                                                                      
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                      
                                                                                    
                                                                                      
                                                                                        
                                                                                
                                                                                    
                                                                                  
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                  
                                                                                      
                                                                                      
                                                                                    
                                                                                        
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                  
                                                                                      
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                    
                                                                                
                                                                                
                                                                                       
                                                                                          
                                                                                      
                                                                                      
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                      
                                                                                    
                                                                                      
                                                                                        
                                                                                
                                                                                    
                                                                                  
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                  
                                                                                      
                                                                                      
                                                                                    
                                                                                        
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                  
                                                                                      
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                    
                                                                                
                                                                                
                                                                                       
                                                                                          
                                                                                      
                                                                                      
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                      
                                                                                    
                                                                                      
                                                                                        
                                                                                
                                                                                    
                                                                                  
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                  
                                                                                      
                                                                                      
                                                                                    
                                                                                        
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                  
                                                                                      
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                    
                                                                                
                                                                                
                                                                                
                                                                                       
                                                                                          
                                                                                      
                                                                                      
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                      
                                                                                    
                                                                                      
                                                                                        
                                                                                
                                                                                    
                                                                                  
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                  
                                                                                      
                                                                                      
                                                                                    
                                                                                        
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                  
                                                                                      
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                    
                                                                                
                                                                                
                                                                                       
                                                                                          
                                                                                      
                                                                                      
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                      
                                                                                    
                                                                                      
                                                                                        
                                                                                
                                                                                    
                                                                                  
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                  
                                                                                      
                                                                                      
                                                                                    
                                                                                        
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                  
                                                                                      
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                    
                                                                                
                                                                                
                                                                                       
                                                                                          
                                                                                      
                                                                                      
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                      
                                                                                    
                                                                                      
                                                                                        
                                                                                
                                                                                    
                                                                                  
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                      
                                                                                        
                                                                                  
                                                                                      
                                                                                      
                                                                                    
                                                                                        
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                  
                                                                                      
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                      
                                                                                      
                                                                                    
                                                                                
                                                                                
