package string

object AnagramsCheck {
  def anagramsCheck(s1: String, s2: String): Boolean = {
    s1.sorted == s2.sorted
  }

}
