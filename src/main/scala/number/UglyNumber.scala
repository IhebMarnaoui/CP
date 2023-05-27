package number

import scala.annotation.tailrec

object UglyNumber {
  @tailrec
  def uglyNumber(number: Int): Boolean = {
    if (number == 1) true
    else if (number % 2 ==0) uglyNumber(number / 2)
    else if (number % 3 ==0) uglyNumber(number / 3)
    else if (number % 5 ==0) uglyNumber(number / 5)
    else false
  }
}
