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
