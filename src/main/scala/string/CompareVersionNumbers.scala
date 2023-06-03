package string

import scala.annotation.tailrec

object CompareVersionNumbers {
  def compareVersionNumbers(version1: String, version2: String): Int = {
    val list1 = version1.split("\\.").toList.map(_.toInt)
    val list2 = version2.split("\\.").toList.map(_.toInt)

    @tailrec
    def compareVersionNumbersByList(list1: List[Int], list2: List[Int]): Int = {
      if (list1.isEmpty && list2.isEmpty) 0
      else if (list1.isEmpty)
        if (list2.exists(_ != 0)) -1
        else 0
      else if (list2.isEmpty)
        if (list1.exists(_ != 0)) 1
        else 0
      else {
        val V1 = list1.head
        val V2 = list2.head
        if (V1 < V2) -1
        else if (V1 > V2) 1
        else compareVersionNumbersByList(list1.tail, list2.tail)
      }
    }

    compareVersionNumbersByList(list1, list2)
  }

}
