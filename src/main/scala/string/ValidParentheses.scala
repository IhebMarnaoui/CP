package string

import scala.annotation.tailrec

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
}
