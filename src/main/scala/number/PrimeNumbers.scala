package number

import scala.annotation.tailrec

object PrimeNumbers {
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(divisor: Int): Boolean = {
      if (divisor > Math.sqrt(Math.abs(n))) true
      else (n % divisor) != 0 && isPrimeTailRec(divisor + 1)
    }

    if (n == 0 || n == 1 || n == -1) false
    else isPrimeTailRec(2)
  }

  def decomposeIntoPrimes(n: Int): List[Int] = {
    @tailrec
    def decomposeIntoPrimesTailRec(remaining: Int, divisor: Int, accumulator: List[Int]): List[Int] = {
      if (remaining > Math.sqrt(remaining)) remaining :: accumulator
      else if (remaining % divisor == 0) decomposeIntoPrimesTailRec(remaining / divisor, divisor, divisor :: accumulator)
      else decomposeIntoPrimesTailRec(remaining, divisor + 1, accumulator)
    }

    decomposeIntoPrimesTailRec(n, 2, List.empty)
  }

}
