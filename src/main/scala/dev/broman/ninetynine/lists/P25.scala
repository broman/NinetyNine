package dev.broman.ninetynine.lists

// P25
// Shuffle a list
// shuffle(List(1, 2, 3, 4))
// => List(2, 4, 1, 3)

import P23.random

object P25 {
  def shuffle[A](list: List[A]): List[A] = {
   // same thing, just use P23
    random(list.length, list)
  }
}
