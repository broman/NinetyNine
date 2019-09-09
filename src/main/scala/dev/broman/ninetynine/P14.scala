package dev.broman.ninetynine

object P14 {
  def copy[A](list: List[A]): List[A] = list.clone.asInstanceOf[List[A]]
}
