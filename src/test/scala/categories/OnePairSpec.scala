package categories

import com.bitmain.categories.{FourOfKind, OnePair}
import com.bitmain.model.{Card, TotalCards}
import org.specs2.matcher.Matchers
import org.specs2.mutable.Specification

class OnePairSpec extends Specification with Matchers {

  "One Pair Test" should {

    val hand = new OnePair(None)

    "calculate hand  for correct in hand combination" in {
      val input = "6C 6D 8C 2D 7C 2H TC 4C 9S AH "
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand  for correct on deck combination" in {
      val input = "6C 9C 8C 2D 7C 2H TC 4C 4D AH "
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand  for correct combination" in {
      val input = "6C 9C 8C 2D 7C 2H TC 4C 9S AH "
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
