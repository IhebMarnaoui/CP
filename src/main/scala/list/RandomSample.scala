package list

import scala.annotation.tailrec
import scala.util.Random

object RandomSample {
  def randomSample[T](list: List[T], k: Int): List[T] = {
    val rnd = new Random(System.currentTimeMillis())

    @tailrec
    def randomSampleTailRec(remaining: Int, accumulator: List[T]): List[T] = {
      if (remaining == 0) accumulator
      else {
        val index = rnd.nextInt(list.length)
        val element = list(index)
        randomSampleTailRec(remaining - 1, element :: accumulator)
      }
    }

    if (k < 0) List.empty
    else randomSampleTailRec(k, List.empty)
  }

}
