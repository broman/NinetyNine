package dev.broman.ninetynine.lists

// P05
// Reverse a list
// reverse(List(1, 2, 3, 4))
// => List(4, 3, 2, 1)


object P05 {
  def reverse[A](list: List[A]): List[A] = {
    // Just add the head onto the end of the tail recursively
    list match {
      case Nil => Nil
      case h :: tail => reverse(tail) ::: List(h)
    }
  }
}
