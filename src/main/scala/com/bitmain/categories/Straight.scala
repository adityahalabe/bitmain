package com.bitmain.categories

import com.bitmain.model.{Card, TotalCards}
import com.bitmain.utils.ArithmeticUtils

class Straight(nextRank : Option[PockerHand]) extends PockerHand(nextRank) {
  override def isThisBestRankPossible(totalCards: TotalCards): Boolean = {

    if(anyFiveCardsAreStraight(totalCards))
      true
    else {
      for(cards <- totalCards.inHandPossibleCombinations){
        for(com <- totalCards.onDeckPossibleCombinations){
          val currentHand = (cards ::: com)
          if(currentHand.length == 5){
            if(isStraight(currentHand))
              return true
          }
        }
      }
      false
    }
  }

  override protected def rankType: String = "Straight"

  private def anyFiveCardsAreStraight(totalCards: TotalCards)  = {
    isStraight(totalCards.inHand) || isStraight(totalCards.onDeck)
  }

  private def isStraight(cards : List[Card]) = {
    val cardValues = cards.map(_.value).sorted
    val updated = if(cardValues.contains(2)) cardValues.map(e => if(e == 14) 1 else e) else cardValues
    ArithmeticUtils.isConsecutive(updated.sorted.toArray) >= 4
  }

}
