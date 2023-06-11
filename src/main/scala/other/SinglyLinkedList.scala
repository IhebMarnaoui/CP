package other

import scala.annotation.tailrec

object SinglyLinkedList {
  /*
      You are given two non-empty linked lists representing two non-negative integers.
      The digits are stored in reverse order, and each of their nodes contains a single digit.
      Add the two numbers and return the sum as a linked list.
      You may assume the two numbers do not contain any leading zero, except the number 0 itself.
   */

  //   * Definition for singly-linked list.
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }

  object Solution {
    def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
      def addLinkedLists(l1: ListNode, l2: ListNode, carry: Int): ListNode = {
        (l1, l2, carry) match {
          case (null, null, 0) => null
          case (n1, n2, c) =>
            val x1 = if (n1 != null) n1.x else 0
            val x2 = if (n2 != null) n2.x else 0

            val sum = x1 + x2 + c
            val newCarry = sum / 10
            val newNode = new ListNode(sum % 10)

            val next1 = if (n1 != null) n1.next else null
            val next2 = if (n2 != null) n2.next else null

            newNode.next = addLinkedLists(next1, next2, newCarry)
            newNode
        }
      }

      addLinkedLists(l1, l2, 0)
    }
  }

}
