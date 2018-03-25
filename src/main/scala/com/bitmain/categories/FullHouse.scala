package com.bitmain.categories

import com.bitmain.model.{Card, TotalCards}

class FullHouse(nextRank : Option[PockerHand]) extends PockerHand(nextRank) {
  override  def isThisBestRankPossible(totalCards: TotalCards): Boolean = {

    if(anyFiveCardsAreFullHouse(totalCards))
      true
    else {
      for((suit,cards) <- totalCards.groupInHandByNumber){
        for(com <- totalCards.onDeckPossibleCombinations){
          val currentHand = (cards ::: com)
          if(currentHand.length == 5){
            if(isFullHouse(currentHand))
              return true
          }
        }
      }
      false
    }
  }

  override protected def rankType: String = "Full House"

  private def anyFiveCardsAreFullHouse(totalCards: TotalCards)  = {
    isFullHouse(totalCards.inHand) || isFullHouse(totalCards.onDeck)
  }

  private def isFullHouse(cards : List[Card]) = {
    cards.groupBy(_.value).exists(_._2.length == 3) && cards.groupBy(_.value).exists(_._2.length == 2)
  }
}
