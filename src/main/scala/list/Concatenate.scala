package list

import scala.annotation.tailrec

object Concatenate {

  def concatenate[T](init: List[T], anotherList: List[T]): List[T] = {
    @tailrec
    def concatenateTailRec[T](elements: List[T], accumulator: List[T]): List[T] = {
      if (elements.isEmpty) accumulator
      else concatenateTailRec(elements.tail, elements.head :: accumulator)
    }

    concatenateTailRec(init.reverse, anotherList)
  }
}
