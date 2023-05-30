package list

import scala.annotation.tailrec


object RunLengthEncoding {
  def runLengthEncoding[T](list: List[T]): List[(T, Int)] = {
    @tailrec
    def runLengthEncodingTailRec(elements: List[T], current_tuple: (T, Int), accumulator: List[(T, Int)]): List[(T, Int)] = {
      if (elements.isEmpty) current_tuple :: accumulator
      else if (elements.head == current_tuple._1) runLengthEncodingTailRec(elements.tail, current_tuple.copy(_2 = current_tuple._2 + 1), accumulator)
      else runLengthEncodingTailRec(elements.tail, (elements.head, 1), current_tuple :: accumulator)
    }

    runLengthEncodingTailRec(list, (list.head, 1), List.empty).reverse
  }
}
