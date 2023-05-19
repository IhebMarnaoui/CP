package list

import scala.annotation.tailrec

object Rotate {
  def rotate[T](list: List[T], elems: Int): List[T] = {
    @tailrec
    def rotateTailRec(remaining: List[T], accumulator: List[T], shift: Int): List[T] = {
      if (remaining.isEmpty && shift == elems) accumulator.reverse
      else if (remaining.isEmpty) rotateTailRec(accumulator.reverse, List.empty, shift)
      else if (shift < elems) rotateTailRec(remaining.tail, remaining.head :: accumulator, shift + 1)
      else remaining ++ accumulator.reverse
    }

    rotateTailRec(list, List.empty, 0)
  }
}
