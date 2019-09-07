package dev.broman.ninetynine.lists

object P15 {
  def duplicateAmount[A](amnt: Int, list: List[A]): List[A] =
    list flatMap { List.fill(amnt)(_) }
}