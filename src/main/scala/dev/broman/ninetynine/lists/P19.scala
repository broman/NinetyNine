package dev.broman.ninetynine.lists

// P19
// Rotate a list N places to the left
// rotate(2, List(1, 2, 3, 4, 5, 6))
// => List(3, 4, 5, 6, 1, 2)


object P19 {
  def rotate[A](n: Int, list: List[A]): List[A] = {
    // Mod n by the length of the list to bound n to the length of the list, then we can just concat a .drop and .take
    val bound = if(list.isEmpty) 0 else n % list.length
    list.drop(bound) ::: list.take(bound)
  }
}
