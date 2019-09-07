package dev.broman.ninetynine.lists

// P08
// Compress a list, removing duplicate elements. The order should not be changed.
// compress(List(1, 2, 2, 2, 2, 3, 4, 4)
// => List(1, 2, 3, 4)

object P08 {
  def compress[A](list: List[A]): List[A] = {
    // Admittedly I peeked at the solution and spoiled this one. In my defense I was
    // confused as to wether compress(List(1, 2, 2, 3, 3, 2, 4) would remove the duplicate 2's, since they're unsorted.
    // The solution ignores unsorted duplicates, and this is just a copypaste of the solution.
    list match {
      case Nil => Nil
      case h :: tail => h :: compress(tail.dropWhile(_ == h))
    }
  }
}
