package com.bitmain.categories

import com.bitmain.model._

object RankIdentifier {

  def identifyRank(totalCards: TotalCards) : String = {
    val highCard = new HighCard(None)
    val onePair = new OnePair(Some(highCard))
    val twoPair = new TwoPair(Some(onePair))
    val threeOfKind = new ThreeOfKind(Some(twoPair))
    val straight = new Straight(Some(threeOfKind))
    val flush = new Flush(Some(straight))
    val fullHouse = new FullHouse(Some(flush))
    val fourOfKind = new FourOfKind(Some(fullHouse))

    val straightFlush = new StraightFlush(Some(fourOfKind))

    straightFlush.identifyBestRank(totalCards)
  }
}
