package com.bitmain.categories

import com.bitmain.model.{Card, TotalCards}

class ThreeOfKind(nextRank : Option[PockerHand]) extends PockerHand(nextRank) {
  override def isThisBestRankPossible(totalCards: TotalCards): Boolean = {
    if(anyFiveCardsAreThreeOfKind(totalCards))
      true
    else {
      for((suit,cards) <- totalCards.groupInHandByNumber){
        for(com <- totalCards.onDeckPossibleCombinations){
          val currentHand = (cards ::: com)
          if(currentHand.length == 5){
            if(isThreeOfKind(currentHand))
              return true
          }
        }
      }
      false
    }
  }

  override protected def rankType: String = "Three of a kind"

  private def anyFiveCardsAreThreeOfKind(totalCards: TotalCards)  = {
    isThreeOfKind(totalCards.inHand) || isThreeOfKind(totalCards.onDeck)
  }

  private def isThreeOfKind(cards : List[Card]) = cards.groupBy(_.value).exists(_._2.length == 3)

}
