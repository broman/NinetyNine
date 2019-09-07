package dev.broman.ninetynine.lists

// P12
// Decode a run-length encoded list
// decode(List(List(1, 1), List(1, 2), List(4, 3), List(2, 4))
// => List(1, 2, 3, 3, 3, 3, 4, 4)

object P12 {
    // This one is easy, since it's guaranteed to be List[List[(a, b)]] you can just make a new list...
  def decode[A](list: List[(Int, A)]): List[A] = {
    list flatMap { e => List.fill(e._1)(e._2) }
  }
}
