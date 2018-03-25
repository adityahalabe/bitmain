package com.bitmain.categories

import com.bitmain.model.{Card, TotalCards}

class FourOfKind(nextRank : Option[PockerHand]) extends PockerHand(nextRank) {
  override  def isThisBestRankPossible(totalCards: TotalCards): Boolean = {
    if(anyFiveCardsAreFourOfKind(totalCards))
      true
    else {
      for((suit,cards) <- totalCards.groupInHandByNumber){
        for(com <- totalCards.onDeckPossibleCombinations){
          val currentHand = (cards ::: com)
          if(currentHand.length == 5){
            if(isFourOfKind(currentHand))
              return true
          }
        }
      }
      false
    }
  }

  override protected def rankType: String = "Four of a kind"

  private def anyFiveCardsAreFourOfKind(totalCards: TotalCards)  = {
    isFourOfKind(totalCards.inHand) || isFourOfKind(totalCards.onDeck)
  }

  private def isFourOfKind(cards : List[Card]) = cards.groupBy(_.value).exists(_._2.length == 4)

}
