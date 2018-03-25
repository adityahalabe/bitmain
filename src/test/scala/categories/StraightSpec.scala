package categories

import com.bitmain.categories.{FourOfKind, Straight}
import com.bitmain.model.{Card, TotalCards}
import org.specs2.matcher.Matchers
import org.specs2.mutable.Specification

class StraightSpec extends Specification with Matchers {

  "Straight Test" should {

    val hand = new Straight(None)

    "calculate hand for correct in hand combination" in {
      val input = "AC 2D 4D 5S 3S 9C 3S KD KS AS"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand for correct on deck combination" in {
      val input = "9C 3S KD KS AS AC 2D 4D 5S 3S"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand for correct combination" in {
      val input = "AC 2D 9C 3S KD 5S 4D KS AS 4C"
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
