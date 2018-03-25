package categories

import com.bitmain.categories.{FourOfKind, FullHouse}
import com.bitmain.model.{Card, TotalCards}
import org.specs2.matcher.Matchers
import org.specs2.mutable.Specification

class FullHouseSpec extends Specification with Matchers {

  "Full House Test" should {

    val hand = new FullHouse(None)

    "calculate hand for correct in hand combination" in {
      val input = "2H 2S 3H 3S 3C 2D 9C 3D 6C TH "
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand for correct on deck combination" in {
      val input = "2D 9C 3D 6C TH 2H 2S 3H 3S 3C "
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand for correct combination" in {
      val input = "2H 2S 3H 3S 3C 2D 9C 3D 6C TH "
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "give false for wrong combination " in {
      val input = " QC QD QS 2S 6S TH JH QH KH AD"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(false)
    }
  }
}
