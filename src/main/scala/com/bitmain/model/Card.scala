package com.bitmain.model

case class Card(faceValue : Char, suit : Char) {
  require(List('H','C','D','S').exists(_ == suit.toUpper))
  require(List('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q','K', 'A').exists(_== faceValue.toUpper))

  def value : Int = faceValue match {
    case 'A' => 14
    case 'T' => 10
    case 'J' => 11
    case 'Q' => 12
    case 'K' => 13
    case _ => Integer.parseInt(faceValue.toString)
  }

}

object Card {

  def apply(inputString : String): Option[Card] = {
    if(inputString.length == 2) {
      Some(Card(inputString.charAt(0), inputString.charAt(1)))
    } else None
  }
}