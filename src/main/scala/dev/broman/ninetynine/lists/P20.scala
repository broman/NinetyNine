package dev.broman.ninetynine.lists

// P19
// Remove the Nth element in a list, returning a tuple of the new list and the removed element
// remove(4, List(1, 2, 3, 4, 5, 6, 7)
// => (List(1, 2, 3, 5, 6, 7), 5)

object P20 {
  def remove[A](n: Int, list: List[A]): (List[A], A) = {
    list.splitAt(n) match {
      case (Nil, _) if n < 0 => null
      case (pre, end :: post)  => (pre ::: post, end)
      case (_, Nil) => null
    }
  }
}
