package dev.broman.ninetynine

// P14
// Duplicate the elements in a list a given number of times
// duplicate(2, List(1, 2, 3)
// => List(1, 1, 2, 2, 3, 3)

object P14 {
  def duplicate[A](amnt: Int, list: List[A]): List[A] = {
    list flatMap { e => List(e, e) }
  }
}
