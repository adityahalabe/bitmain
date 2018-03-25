package categories

import com.bitmain.categories.StraightFlush
import com.bitmain.model.{Card, TotalCards}
import org.specs2.matcher.Matchers
import org.specs2.mutable.Specification

class StraightFlushSpec extends Specification with Matchers {

  "Straight Flush Test" should {

    val hand = new StraightFlush(None)

    "calculate hand for correct in hand combination" in {
      val input = "TH JH QH KH AH QC QD QS 2S 6S"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand for correct on deck combination" in {
      val input = " QC QD QS 2S 6S TH JH QH KH AH"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      hand.isThisBestRankPossible(totalCards) mustEqual(true)
    }

    "calculate hand for correct combination" in {
      val input = " QC QD QS 2S 6S TH JH QH KH AH"
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
