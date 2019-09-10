package dev.broman.ninetynine.lists

// P08
// Compress a list, removing duplicate elements. The order should not be changed.
// compress(List(1, 2, 2, 2, 2, 3, 4, 4)
// => List(1, 2, 3, 4)

object P08 {
  def compress[A](list: List[A]): List[A] = {
    list match {
      case Nil => Nil
      case h :: tail => h :: compress(tail.dropWhile(_ == h))
    }
  }
}
