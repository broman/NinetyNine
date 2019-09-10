package dev.broman.ninetynine.lists

// P17
// Split a list into two parts
// split(3, List(1, 2, 3, 4, 5)
// => (List(1, 2, 3), List(4, 5))

object P17 {
  def split[A](index: Int, list: List[A]): (List[A], List[A]) =
    (list.take(index), list.drop(index))
}
