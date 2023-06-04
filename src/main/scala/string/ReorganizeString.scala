package string

import scala.annotation.tailrec

object ReorganizeString {
  def reorganizeString(string: String): String = {

    @tailrec
    def reorganizeStringTailRec(charCount: Map[Char, Int], forbidden: Char = '\u0000', accumulator: String = ""): String = {
      if (charCount.isEmpty) accumulator
      else {
        val newChar = charCount.filter(_._1 != forbidden).maxBy(_._2)._1
        val newCharCount = {
          if (charCount(newChar) == 1) charCount - newChar
          else charCount + (newChar -> (charCount(newChar) - 1))
        }
        reorganizeStringTailRec(newCharCount, newChar, accumulator + newChar)
      }
    }

    val charCount: Map[Char, Int] = string.foldLeft(Map[Char, Int]()) {
      case (map, newChar) => map + (newChar -> (map.getOrElse(newChar, 0) + 1))
    }

    if (charCount.values.exists(_ > (string.length + 1) / 2)) ""
    else reorganizeStringTailRec(charCount)
  }
}
