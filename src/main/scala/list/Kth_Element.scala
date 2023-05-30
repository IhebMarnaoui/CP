package list

import scala.annotation.tailrec

object Kth_Element {
  def find[T](list: List[T], index: Int): Int = {
    @tailrec
    def findTailRec(elements: List[T], current_index: Int): T = {
      if (current_index == index) elements.head
      else findTailRec(elements.tail, current_index + 1)
    }

    if (index < 0) throw new NoSuchElementException
    else find(list, 0)
  }

}
