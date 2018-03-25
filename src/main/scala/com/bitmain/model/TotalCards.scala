package com.bitmain.model

case class TotalCards(inHand : List[Card], onDeck : List[Card], allCards : List[Card]) {

  def groupInHandBySuit = inHand.groupBy(_.suit)

  def groupInHandByNumber = inHand.groupBy(_.faceValue)

  def groupOnDeckBySuit = onDeck.groupBy(_.suit)

  def groupOnDeckByNumber = onDeck.groupBy(_.faceValue)

  def onDeckPossibleCombinations = {
    var combinations = List.empty[List[Card]]
    for(i <- 1 to onDeck.length){
      combinations = onDeck.take(i) :: combinations
    }
    combinations.reverse
  }

  def inHandPossibleCombinations = {
    inHand.toSet[Card].subsets.map(_.toList).toList
  }
}
