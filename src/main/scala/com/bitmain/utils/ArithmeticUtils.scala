package com.bitmain.utils

object ArithmeticUtils {

  def isConsecutive(seq: Array[Int]): Int = {
    val count = seq.sliding(2).count(a => a(0)+1 == a(1))
    count
  }
}
