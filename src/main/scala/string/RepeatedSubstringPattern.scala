package string


object RepeatedSubstringPattern {

  def repeatedSubstringPattern(s: String): Boolean = {
    val n = s.length
    for (i <- 1 until n / 2 + 1) {
      if (n % i == 0) {
        val substring = s.take(i)
        if (s == substring * (n / i)) {
          return true
        }
      }
    }
    false
  }

}