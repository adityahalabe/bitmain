package com.bitmain.categories

import com.bitmain.model.TotalCards

abstract class PockerHand(nextRank : Option[PockerHand]) {

  def isThisBestRankPossible(totalCards: TotalCards) : Boolean
  protected def rankType : String

  def identifyBestRank(totalCards: TotalCards) : String = {
    if(isThisBestRankPossible(totalCards))
      rankType
    else if (nextRank.isDefined)
      nextRank.get.identifyBestRank(totalCards)
    else rankType
  }

}
