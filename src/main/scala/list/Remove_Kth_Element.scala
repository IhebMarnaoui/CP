package list

import scala.annotation.tailrec

object Remove_Kth_Element {
  def remove[T](from: List[T], index: Int): List[T] = {
    @tailrec
    def removeTailRec(elements: List[T], current_index: Int, predecessors: List[T]): List[T] = {
      if (elements.isEmpty) predecessors.reverse
      else if (current_index == index) predecessors.reverse ++ elements.tail
      else removeTailRec(elements.tail, current_index + 1, elements.head :: predecessors)
    }

    if (index < 0) from
    else removeTailRec(from, 0, List.empty)
  }
}
