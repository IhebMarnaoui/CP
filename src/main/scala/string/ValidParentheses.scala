package string

import scala.annotation.tailrec
import scala.jdk.Accumulator

object ValidParentheses {
  def isValid(string: String): Boolean = {
    @tailrec
    def isValidTailRec(remaining: String, open: Int): Boolean = {
      if (remaining.isEmpty) open == 0
      else if (open == 0 && remaining.head == ')') false
      else if (remaining.head == '(') isValidTailRec(remaining.tail, open + 1)
      else isValidTailRec(remaining.tail, open - 1)
    }

    isValidTailRec(string, 0)
  }

  def generateValidParentheses(n: Int): List[String] = {
    @tailrec
    def generateValidParenthesesTailRec(remaining: Int, accumulator: Set[String]): Set[String] = {
      if (remaining == 0) accumulator
      else {
        val current = for {
          string <- accumulator
          index <- 0 until string.length
        } yield {
          val (before, after) = string.splitAt(index)
          s"$before()$after"
        }
        generateValidParenthesesTailRec(remaining - 1, current)
      }
    }
    if (n ==0) List.empty
    else generateValidParenthesesTailRec(n - 1, Set("()")).toList
  }
}
