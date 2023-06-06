package number

object Palindrome {
  def palindrome(x: Int): Boolean = {
    x.toString == x.toString.reverse
  }
}
