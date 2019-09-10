package dev.broman.ninetynine.lists

import scala.collection.mutable.ListBuffer

// P18
// Extract a slice from the list starting at I inclusive and ending at K exclusive
// split(3, 6, List(1, 2, 3, 4, 5, 6, 7, 8)
// => List(4, 5, 6)

object P18 {
  def slice[A](I: Int, K: Int, list: List[A]): List[A] = {
    // ok cat since u wanted iterative here
    val output: ListBuffer[A] = ListBuffer[A]()
    for (i <- I until K) {
      output.addOne(list(i))
    }
    output.toList
  }
}
