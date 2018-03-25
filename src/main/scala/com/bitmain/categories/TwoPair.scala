package com.bitmain.categories

import com.bitmain.model.{Card, TotalCards}

class TwoPair(nextRank : Option[PockerHand]) extends PockerHand(nextRank) {
  override def isThisBestRankPossible(totalCards: TotalCards): Boolean = {

    if(anyFiveCardsAreTwoPair(totalCards))
      true
    else {
      for((suit,cards) <- totalCards.groupInHandByNumber){
        for(com <- totalCards.onDeckPossibleCombinations){
          val currentHand = (cards ::: com)
          if(currentHand.length == 5){
            if(isTwoPair(currentHand))
              return true
          }
        }
      }
      false
    }
  }

  override protected def rankType: String = "Two Pair"

  private def anyFiveCardsAreTwoPair(totalCards: TotalCards)  = {
    isTwoPair(totalCards.inHand) || isTwoPair(totalCards.onDeck)
  }

  private def isTwoPair(cards : List[Card]) = cards.groupBy(_.value).filter(_._2.length == 2).size == 2
}
