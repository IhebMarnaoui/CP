package number

import scala.annotation.tailrec

object ReverseInteger {
  def reverseInteger(number: Int): Int = {
    @tailrec
    def reverseIntegerTailRec(number: Int, accumulator: Int): Int = {
      if (number == 0) accumulator
      else {
        val lastDigit = number % 10
        val res = accumulator * 10 + lastDigit
        if ((res >= 0) != (accumulator >= 0)) 0 //overflow
        else reverseIntegerTailRec(number / 10, accumulator)
      }
    }

    if (number == Int.MinValue) 0
    else if (number >= 0) reverseIntegerTailRec(number, 0)
    else -reverseIntegerTailRec(-number, 0)
  }
}
