package string

object RansomNote {
  def ransomNote(note: String, magazine: String): Boolean = {
    def numberOfLetters(string: String): Map[Char, Int] = {
      string.foldLeft(Map[Char, Int]()) {
        case (map, char) => map + (char -> (map.getOrElse(char, 0) + 1))
      }
    }

    val noteLetters = numberOfLetters(note)
    val magazineLetter = numberOfLetters(magazine)
    noteLetters.keySet.forall(char => noteLetters.getOrElse(char, 0) <= magazineLetter.getOrElse(char, 0))
  }

}
