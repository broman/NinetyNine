package dev.broman.ninetynine.lists

// P07
// Flatten a nested list
// flatten(List(List(1, 2, 3), List(4, 5, 6))
// => List(1, 2, 3, 4, 5, 6)

object P07 {
  def flatten(list: List[Any]): List[Any] = {
    // Use Scala flatMap to unpack every element in a list, recursing into a list if need be (List[List[List[_]]])
    list flatMap {
      case ls: List[_] => flatten(ls)
      case e => List(e)
    }
  }
}
