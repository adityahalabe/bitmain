import com.bitmain.categories.{FourOfKind, RankIdentifier}
import com.bitmain.model.{Card, TotalCards}
import org.specs2.matcher.Matchers
import org.specs2.mutable.Specification

class IngrationSpec extends Specification with Matchers {

  "Integration spec" should {

    "identify high card for non matching combination" in {
      val input = "3D 5S 2H QD TD 6S KH 9H AD QH"
      val cards = input.trim.split(" ").map(entry => Card(entry)).flatten.toList
      val totalCards = TotalCards(cards.take(5),cards.drop(5),cards)

      RankIdentifier.identifyRank(totalCards) mustEqual("highest-card")
    }

  }
}
