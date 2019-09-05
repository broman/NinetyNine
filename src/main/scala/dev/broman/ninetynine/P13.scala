package dev.broman.ninetynine

// P13
// Implement run-length encoding without using functions from other problems.

object P13 {
  def encodeDirect[A](list: List[A]): List[(Int, A)] = {
    // Well this one isn't too bad, you can just use P09 to pack and encode at the same time
    if(list.isEmpty) {
      Nil
    } else {
      val (packed, next) = list span { _ == list.head } // From P09
      (packed.length, packed.head) :: encodeDirect(next) // TIL you can just add tuples together like this...
    }
  }
}
