package dev.broman.ninetynine

// P11
// Modify P10 so that unique elements are not stored as a list.
// encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
// => List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

import P10.encode

object P11 {
  def encodeModified[A](list: List[A]): List[Any] = {
    encode(list) map { t => if (t._1 == 1) t._2 else t }
  }
}
