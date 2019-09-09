package dev.broman.ninetynine.lists

// P16
// Duplicate the elements in a list a given number of times
// duplicateN(3, List('a, 'b, 'c, 'c, 'd))
// => List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

object P16 {
  def duplicateNum[A](amnt: Int, list: List[A]): List[A] = {
    list flatMap { List.fill(amnt)(_) }
  }
}
