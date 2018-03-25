package com.bitmain.categories

import com.bitmain.model.{Card, TotalCards}

class HighCard(nextRank : Option[PockerHand]) extends PockerHand(nextRank) {
  override def isThisBestRankPossible(totalCards: TotalCards): Boolean = true

  override protected def rankType: String = "highest-card"

}
