package dev.broman.ninetynine.lists

// P09
// Pack a list of duplicate elements into sublists.
// pack(List(1, 2, 3, 3, 3, 3, 3, 4, 4)
// => List(List(1), List(2), List(3, 3, 3, 3, 3), List(4, 4))

object P09 {
  def pack[A](list: List[A]): List[List[A]] = {
    // The question for this one confused me as well. The instructions specifically read
    /// If a list contains repeated elements they should be placed in separate sublists.
    // But the example packed unique elements into a list too! Oh well.
    val (packed, next) = list span { _ == list.head }
    // creates two lists, one of already packed elements and the rest of the unpacked elements
    if(next == Nil) List(packed) // there is no more elements in the list to pack
    else packed :: pack(next) // pack the next list and add it on to the rest of the packed elements
  }
}
