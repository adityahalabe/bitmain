package com.bitmain.categories

import com.bitmain.model.{Card, TotalCards}
import com.bitmain.utils.ArithmeticUtils

class StraightFlush(nextRank : Option[PockerHand]) extends PockerHand(nextRank) {
  override def isThisBestRankPossible(totalCards: TotalCards): Boolean = {

    if(anyFiveCardsAreStraightFlush(totalCards))
      true
    else {
      for((suit,cards) <- totalCards.groupInHandBySuit){
        for(com <- totalCards.onDeckPossibleCombinations){
          val currentHand = (cards ::: com)
          if(currentHand.length == 5){
            if(isStraightFlush(currentHand))
              return true
          }
        }
      }
      false
    }
  }

  override protected def rankType: String = "Straight Flush"

  private def anyFiveCardsAreStraightFlush(totalCards: TotalCards)  = {
    isStraightFlush(totalCards.inHand) || isStraightFlush(totalCards.onDeck)
  }

  private def isStraightFlush(cards : List[Card]) = {
    val fiveCardMap = cards.groupBy(_.suit).filter(_._2.length >= 5)
    if(fiveCardMap.nonEmpty){
      fiveCardMap.map { case (k, cards) =>
        val values = cards.map(_.value).sorted
        val updated = if(values.contains(2)) values.map(e => if(e == 14) 1 else e) else values
        val conseq = ArithmeticUtils.isConsecutive(updated.toArray)
        conseq >= 4
      }.toList.contains(true)
    }else
      false
  }

}
