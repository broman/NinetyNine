package dev.broman.ninetynine.lists

// P21
// Insert an element into the nth position in a list
// insert(2, 2, List(1, 2, 3, 4, 5)
// => List(1, 2, 2, 3, 4, 5)

object P21 {
  def insert[A](ins: A, n: Int, list: List[A]): List[A] = {
    list.take(n) ::: List(ins) ::: list.drop(n)
  }
}
