package categories

import com.bitmain.categories.{FourOfKind, ThreeOfKind}
import com.bitmain.model.{Card, TotalCards}
import org.specs2.matcher.Matchers
import org.specs2.mutable.Specification

class ThreeOfKindSpec extends Specification with Matchers {

  "Three of Kind Test" should {

    val hand = new ThreeOfKind(None)

    "calculate hand  for correct in hand combination" in {
      val input = "2C 2D 2H 3C 4H KC KS AH TC AS"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand  for correct on deck combination" in {
      val input = "3C 4H KS AH 3C 4H AS 2C 2D 2H"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand  for correct combination" in {
      val input = "KS AH 2H 3C 4H KC 2C TC 2D AS"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "give false for wrong combination " in {
      val input = "3D 5S 2H QD TD 6S KH 9H AD QH"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(false)
    }
  }
}
