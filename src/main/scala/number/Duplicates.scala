package number

object Duplicates {
  def duplicates(list: List[Int]): Int = {
    list.foldLeft(0)(_ ^ _)
  }

}
