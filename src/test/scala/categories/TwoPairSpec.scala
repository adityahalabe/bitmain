package categories

import com.bitmain.categories.{FourOfKind, TwoPair}
import com.bitmain.model.{Card, TotalCards}
import org.specs2.matcher.Matchers
import org.specs2.mutable.Specification

class TwoPairSpec extends Specification with Matchers {

  "Two Pair Test" should {

    val hand = new TwoPair(None)

    "calculate hand  for correct in hand combination" in {
      val input = "AH 2C 2S AD 3C QH KS JS JD KD"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand  for correct on deck combination" in {
      val input = "AH 2C 9S AD 3C KH KS JS JD KD"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand  for correct combination" in {
      val input = "AH 2C 9S AD 3C QH KS JS JD KD"
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
