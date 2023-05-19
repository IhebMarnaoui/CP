package tree

import scala.annotation.tailrec

sealed abstract class BinaryTree[+T] {
  def value: T
  def left: BinaryTree[T]
  def right: BinaryTree[T]

  def isEmpty: Boolean
  def isLeaf: Boolean
  def collectLeaves: List[BinaryTree[T]]
  def leafCount: Int
  def size: Int
}

case object BinaryTreeEnd extends BinaryTree[Nothing] {
  override def value: Nothing = throw new NoSuchElementException
  override def left: BinaryTree[Nothing] = throw new NoSuchElementException
  override def right: BinaryTree[Nothing] = throw new NoSuchElementException

  override def isEmpty: Boolean = true
  override def isLeaf: Boolean = false
  override def collectLeaves: List[BinaryTree[Nothing]] = List.empty
  override def leafCount: Int = 0

  override val size: Int = 0
}

case class BinaryTreeNode[+T](override val value: T, override val left: BinaryTree[T], override val right: BinaryTree[T]) extends BinaryTree[T] {
  override def isEmpty: Boolean = false

  override def isLeaf: Boolean = left.isEmpty && right.isEmpty

  override def collectLeaves: List[BinaryTree[T]] = {
    @tailrec
    def collectLeavesTailRec(remaining: List[BinaryTree[T]], accumulator: List[BinaryTree[T]]) : List[BinaryTree[T]] = {
      if (remaining.isEmpty) accumulator
      else if (remaining.head.isEmpty) collectLeavesTailRec(remaining.tail, accumulator)
      else if (remaining.head.isLeaf) collectLeavesTailRec(remaining.tail, remaining.head :: accumulator)
      else {
        val node = remaining.head
        collectLeavesTailRec(node.right :: node.left :: remaining, accumulator)
      }
    }
    collectLeavesTailRec(List(this), List.empty)
  }

  override def leafCount: Int = collectLeaves.length

  override val size: Int = 1 + left.size + right.size
}

