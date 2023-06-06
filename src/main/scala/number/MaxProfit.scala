package number

object MaxProfit {
  def maxProfit(prices: Array[Int]): Int = {
    val (minPrice, maxProfit) = prices.foldLeft((Int.MaxValue, 0)) {
      case ((min, max), price) =>
        val newMin = math.min(min, price)
        val newProfit = math.max(max, price - min)
        (newMin, newProfit)
    }

    maxProfit
  }
}
