package list

import scala.annotation.tailrec

object Reverse {

  def reverse[T](list: List[T]): List[T] = {
    @tailrec
    def reverseTailRec[T](elements: List[T], accumulator: List[T]): List[T] = {
      if (elements.isEmpty) accumulator
      else reverseTailRec(elements.tail, elements.head :: accumulator)
    }

    reverseTailRec(list, List.empty)
  }

}
