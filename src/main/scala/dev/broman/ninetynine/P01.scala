package dev.broman.ninetynine

// P01
// Find the last element of a list.
// last(List(0, 1, 2, 3)
// => 3

object P01 {
  @scala.annotation.tailrec
  def last[A](list: List[A]): A = {
    list match {
      case h :: Nil => h // In the case that the head of the list is h, and the tail is Nil (meaning we've reached the end of the list)
      case _ :: tail => last(tail)
      case _ => throw new NoSuchElementException
    }
  }
}