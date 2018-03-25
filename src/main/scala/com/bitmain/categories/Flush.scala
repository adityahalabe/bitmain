package com.bitmain.categories

import com.bitmain.model.{Card, TotalCards}

class Flush(nextRank : Option[PockerHand]) extends PockerHand(nextRank) {
  override  def isThisBestRankPossible(totalCards: TotalCards): Boolean = {

    if(anyFiveCardsAreFlush(totalCards))
      true
    else {
      for((suit,cards) <- totalCards.groupInHandBySuit){
        for(com <- totalCards.onDeckPossibleCombinations){
          val currentHand = (cards ::: com)
          if(currentHand.length == 5){
            if(isFlush(currentHand))
              return true
          }
        }
      }
      false
    }
  }

  override protected def rankType: String = "Flush"

  private def anyFiveCardsAreFlush(totalCards: TotalCards)  = {
    isFlush(totalCards.inHand) || isFlush(totalCards.onDeck)
  }

  private def isFlush(cards : List[Card]) = cards.groupBy(_.suit).exists(_._2.length >= 5)

}
