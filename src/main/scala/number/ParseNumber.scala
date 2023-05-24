package number

import scala.annotation.tailrec

object ParseNumber {
  def parseNumber(string: String): Int = {
    val Space = ' '
    val Numbers = "0123456789".toSet
    val Plus = '+'
    val Minus = '-'

    def maxRange(sign: Int): Int = if (sign >= 0) Int.MaxValue else Int.MinValue

    @tailrec
    def parseNumbertailRec(string: String, sign: Int, accumulator: Int): Int = {
      if (string.isEmpty || !Numbers.contains(string.charAt(0))) accumulator
      else {
        val digit = string.charAt(0) - '0'
        val res = accumulator * 10 + digit * sign

        if ((sign >= 0) != (res >= 0)) maxRange(sign)
        else parseNumbertailRec(string.substring(1), sign, res)
      }
    }

    if (string.isEmpty) 0
    else if (string.charAt(0) == Space) parseNumber(string.substring(1))
    else if (string.charAt(0) == Plus) parseNumbertailRec(string.substring(1), 1, 0)
    else if (string.charAt(0) == Minus) parseNumbertailRec(string.substring(1), -1, 0)
    else parseNumbertailRec(string.substring(1), 1, 0)

  }

}
