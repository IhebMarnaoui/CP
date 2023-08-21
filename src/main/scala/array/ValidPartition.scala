package array

//object ValidPartition extends App {
//  def validPartition(nums: Array[Int]): Boolean = {
//    def isTwoEqual(idx: Int): Boolean = {
//      idx + 1 < nums.length && nums(idx) == nums(idx + 1)
//    }
//
//    def isThreeEqual(idx: Int): Boolean = {
//      idx + 2 < nums.length && nums(idx) == nums(idx + 1) && nums(idx) == nums(idx + 2)
//    }
//
//    def isThreeConsecutive(idx: Int): Boolean = {
//      idx + 2 < nums.length && nums(idx) + 1 == nums(idx + 1) && nums(idx + 1) + 1 == nums(idx + 2)
//    }
//
//    val n = nums.length
//    (0 until n).map { index =>
//      if (isTwoEqual(index)) {
//        isThreeEqual(index + 2) || isThreeConsecutive(index + 2) || isTwoEqual(index + 2)
//      } else if (isThreeEqual(index) || isThreeConsecutive(index)) {
//        isThreeEqual(index + 3) || isThreeConsecutive(index + 3) || isTwoEqual(index + 3)
//      } else {
//        false
//      }
//    }.head
//  }
//
//  println(validPartition(Array(993335, 993336, 993337, 993338, 993339, 993340, 993341)))
//}
