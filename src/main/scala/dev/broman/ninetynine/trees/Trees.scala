package dev.broman.ninetynine.trees

sealed abstract class Tree[+T]

case class Node[+T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T] {
  override def toString: String = s"T($value $left $right)"
}

case object End extends Tree[Nothing] {
  override def toString = "."
}

object Node {
  def apply[T](value: T): Node[T] = Node(value, End, End)
}

object Tree {
  // P55
  // In a completely balanced binary tree, the following property holds for every node:
  //// The number of nodes in its left subtree and the number of nodes in its right subtree are almost equal,
  //// which means their difference is not greater than one.
  def cBalanced[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
    case n if n < 1 => List(End)
    case n if n % 2 != 0 =>
      val subtrees = cBalanced(n / 2, value)
      subtrees.flatMap(l => subtrees.map(r => Node(value, l, r)))
    case n if n % 2 == 0 =>
      val lesserSubtrees = cBalanced((n - 1) / 2, value)
      val greaterSubtrees = cBalanced((n - 1) / 2 + 1, value)
      lesserSubtrees.flatMap(l => greaterSubtrees.flatMap(g => List(Node(value, l, g), Node(value, g, l))))
  }

  // P56
  // Let us call a binary tree symmetric if you can draw a vertical line through the root node and then the right subtree is the
  // mirror image of the left subtree. Add an isSymmetric method to the Tree class to check whether a given binary tree is symmetric.
  // Hint: Write an isMirrorOf method first to check whether one tree is the mirror image of another.
  // We are only interested in the structure, not in the contents of the nodes.
  def isSymmetric: Boolean = {

  }


}