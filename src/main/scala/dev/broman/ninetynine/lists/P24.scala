package dev.broman.ninetynine.lists

// P24
// Lotto: Draw N different random numbers from the set 1..M
// lotto(6, 49)
// => List(23, 1, 17, 33, 21, 37)

import P23.random

object P24 {
  // this is just an extension of random() from P23
  def lotto(amnt: Int, n: Int): List[Int] = {
    random(amnt, List.range(1, n + 1))
  }
}
