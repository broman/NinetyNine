package dev.broman.ninetynine

// P02
// Find the second to last last element of a list.
// penultimate(List(0, 1, 2, 3)
// => 2

object P02 {
  @scala.annotation.tailrec
  def penultimate[A](list: List[A]): A = {
    // Slight modification to P01.last, here we check if the tail of the tail is nil
    list match {
      case h :: _ :: Nil => h
      case _ :: tail => penultimate(tail)
      case _ => throw new NoSuchElementException
    }
  }
}
