package string

import scala.annotation.tailrec

object CountChars {

  def countChars(string: String): Map[Char, Int] = {
    @tailrec
    def CountCharsTailRec(remaining: String, accumulator: Map[Char, Int]): Map[Char, Int] = {
      if (remaining.isEmpty) accumulator
      else if (accumulator.contains(remaining.head)) {
        val count = accumulator(remaining.head)
        CountCharsTailRec(remaining.tail, accumulator + (remaining.head -> (count + 1)))
      }
      else CountCharsTailRec(remaining.tail, accumulator + (remaining.head -> 1))
    }

    CountCharsTailRec(string, Map.empty)
  }
}
