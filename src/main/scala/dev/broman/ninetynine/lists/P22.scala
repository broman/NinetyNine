package dev.broman.ninetynine.lists

// P22
// Generate a list of integers in a given range
// range(4, 9)
// => List(4, 5, 6, 7, 8, 9)

object P22 {
  def range(n: Int, m: Int): List[Int] = {
    if(m < n) Nil
    else n :: range(n + 1, m)
  }
}
