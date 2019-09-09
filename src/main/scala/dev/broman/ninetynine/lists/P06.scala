package dev.broman.ninetynine.lists

// P06
// Check if a list is a palindrome.
// isPalindrome(List(1, 2, 2, 1)
// => True
// isPalindrome(List(1, 2, 3)
// => False

import dev.broman.ninetynine.lists.P05.reverse

object P06 {
  // My first thought is to push each new element onto a stack, and pop it if the current element == peeked element
  // Problem is that this would fail for lists with an odd amount of numbers but is still symmetrical, like 1, 2, 1
  // But then I remembered the definition of a palindrome is just forwards = backwards. So...
  def isPalindrome[A](list: List[A]): Boolean = list == reverse(list)
}
