package string

object ReverseWords {
  def reverseWords(string: String): String = {
    string.split(" ").filter(_.nonEmpty).toList.reverse.mkString(" ")
  }
}
