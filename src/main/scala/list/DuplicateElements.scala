package list

import scala.annotation.tailrec

object DuplicateElements {
  def duplicateElements[T](list: List[T], times: Int): List[T] = {
    @tailrec
    def duplicateElementsTailRec(remaining: List[T], accumulator: List[T], count: Int): List[T] = {
      if (remaining.isEmpty) accumulator.reverse
      else if (count < times) duplicateElementsTailRec(remaining, remaining.head :: accumulator, count + 1)
      else duplicateElementsTailRec(remaining.tail, accumulator, 0)
    }

    duplicateElementsTailRec(list, List.empty, 0)
  }
}
