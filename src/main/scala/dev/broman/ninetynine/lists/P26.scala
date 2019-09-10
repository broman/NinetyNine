package dev.broman.ninetynine.lists

// P26
// Generate the combinations of K distinct objects chosen from the N elements of a list
// combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
// => List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...

object P26 {
  // so fuck this problem have the copypaste solution
  def flatMapSublists[A,B](ls: List[A])(f: List[A] => List[B]): List[B] =
    ls match {
      case Nil => Nil
      case sublist@ _ :: tail => f(sublist) ::: flatMapSublists(tail)(f)
    }

  def combinations[A](n: Int, ls: List[A]): List[List[A]] =
    if (n == 0) List(Nil)
    else flatMapSublists(ls) { sl =>
      combinations(n - 1, sl.tail) map {sl.head :: _}
    }
}
