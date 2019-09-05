package dev.broman.ninetynine

// P10
// Run-length encode a list
// encode(List(1, 2, 3, 3, 3, 3, 4, 4)
// => List(List(1, 1), List(1, 2), List(4, 3), List(2, 4)

import P09.pack

object P10 {
  def encode[A](list: List[A]): List[(Int, A)] = {
    pack(list) map { e => (e.length, e.head)}
  }
}
