package dev.broman.ninetynine.lists

// P04
// Find the number of elements in a list
// length(List(1, 2, 3, 4))
// => 4

object P04 {
  def length[A](list: List[A]): Int = {
    // Seems like the simplest way to do this w/o builtins is adding 1 each time an element has a tail
    list match {
      case Nil => 0
      case _ :: tail => 1 + length(tail)
    }
  }
  // Checking the solution reveals that there is a theoretically faster way, but the JVM doesn't allow for it
  // unless the function is final. The tailrec annotation guarantees this either way.
  def lengthTailRecursive[A](ls: List[A]): Int = {
    @scala.annotation.tailrec
    def lengthR(result: Int, curList: List[A]): Int = curList match {
      case Nil       => result
      case _ :: tail => lengthR(result + 1, tail)
    }
    lengthR(0, ls)
  }
}
