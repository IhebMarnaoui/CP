package string

import scala.annotation.tailrec

object LongestSubstring {
  def lengthOfLongestSubstring(s: String): Int = {
    @tailrec
    def lengthOfLongestSubstringTailRec(remaining: String, substring: String, accumulator: Int): Int = {
      if (remaining.isEmpty) accumulator
      else if (!substring.contains(remaining.head)) lengthOfLongestSubstringTailRec(remaining.tail, substring + remaining.head, accumulator.max(substring.length + 1))
      else {
        val updatedSubstring = substring.substring(substring.indexOf(remaining.head) + 1) + remaining.head
        lengthOfLongestSubstringTailRec(remaining.tail, updatedSubstring, accumulator.max(substring.length))
      }
    }

    lengthOfLongestSubstringTailRec(s, "", 0)
  }
}
