package com.bitmain.categories

import com.bitmain.model.{Card, TotalCards}

class OnePair(nextRank : Option[PockerHand]) extends PockerHand(nextRank) {
  override def isThisBestRankPossible(totalCards: TotalCards): Boolean = {

    if(anyFiveCardsAreOnePair(totalCards))
      true
    else {
      for((suit,cards) <- totalCards.groupInHandByNumber){
        for(com <- totalCards.onDeckPossibleCombinations){
          val currentHand = (cards ::: com)
          if(currentHand.length == 5){
            if(isOnePair(currentHand))
              return true
          }
        }
      }
      false
    }
  }

  override protected def rankType: String = "One Pair"

  private def anyFiveCardsAreOnePair(totalCards: TotalCards)  = {
    isOnePair(totalCards.inHand) || isOnePair(totalCards.onDeck)
  }

  private def isOnePair(cards : List[Card]) = {
    cards.groupBy(_.value).exists(_._2.length == 2)
  }
}
