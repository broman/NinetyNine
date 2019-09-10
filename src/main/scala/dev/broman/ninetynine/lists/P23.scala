package dev.broman.ninetynine.lists

// P23
// Extract a given number of randomly selected elements from a list
// random(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
// => List('e, 'd, 'a)

import scala.util.Random
import P20.remove

object P23 {
  def random[A](amnt: Int, list: List[A]): List[A] = {
    if(amnt <= 0) Nil
    else {
      val (newList, elem) = remove(new Random().nextInt(list.length), list)
      elem :: random(amnt - 1, newList)
    }
  }
}
