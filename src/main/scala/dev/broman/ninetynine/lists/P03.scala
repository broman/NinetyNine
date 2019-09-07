package dev.broman.ninetynine.lists

// P03
// Find the Kth element in the list
// nth(2, List(1, 2, 3, 4, 5)
// => 3

object P03 {
  // Gonna cheat here since there really is no faster way to access a value in a hash table
  def nth[A](index: Int, list: List[A]): A = {
    if(index >= 0) list(index)
    else throw new NoSuchElementException
  }
}
