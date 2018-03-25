package com.bitmain.application

import com.bitmain.categories.RankIdentifier
import com.bitmain.model.{Card, TotalCards}

object ApplicationDemo {

  def main(args: Array[String]): Unit = {
    var inputCards = scala.io.StdIn.readLine()
    var output = List.empty[String]
    while(inputCards != "") {

      val cards = inputCards.trim.split(" ").map(entry => Card(entry)).flatten.toList
      if(cards.length != 10) {
        output = s"This input is not as per syntax : $inputCards " :: output
      } else {
        val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)
        val bestHand = RankIdentifier.identifyRank(totalCards)
        output = s"Hand: ${totalCards.inHand.mkString(" ")} Deck: ${totalCards.onDeck.mkString(" ")} Best hand: $bestHand"  :: output
      }
      inputCards = scala.io.StdIn.readLine()

    }
    println("--------------------------Output-----------------------------------")
    output.reverse.foreach(println(_))
  }
}
