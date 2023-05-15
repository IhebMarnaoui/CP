package number

object LargestNumber {
  def largestNumber(numbers: List[Int]): String = {
    implicit val numbersOrdering: Ordering[Int] = Ordering.fromLessThan { (x, y) =>
      val xString = x.toString
      val yString = y.toString
      (xString + yString).compareTo(yString + xString) >= 0

    }
    val largest = numbers.sorted.mkString("")
    if (numbers.isEmpty || largest.charAt(0) == '0') "0"
    else largest
  }
}
