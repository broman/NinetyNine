package dev.broman.ninetynine.arithmetic

class Arithmetic(val start: Int) {
  // P31: Check if a given number is prime
  // My original solution worked but I was so caught up in fixing the
  // posted solution that I might as well keep the posted, fixed one
  def isPrime: Boolean =
    (start > 1) && (Arithmetic.primes takeWhile {_ <= Math.sqrt(start)} forall {start % _ != 0})

  // P32: Determine the greatest common divisor of two positive integers
  def gcd(i: Int, k: Int): Int = {
    if(k == 0) i else gcd(k, i % k)
  }

  // P33: Determine whether two positive integers are coprime
  // A pair of integers are coprime if and only if the only number that divides them both is 1
  // aka gcd(a,b) == 1
  def isCoprimeTo(i: Int): Boolean = gcd(start, i) == 1

  // P34: Calculate Euler's totient function
  // Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
  def totient: Int = (1 to start) count {new Arithmetic(start).isCoprimeTo(_)}
}

object Arithmetic {
  implicit def intArithmetic(i: Int): Arithmetic = new Arithmetic(i)
  val primes = LazyList.cons(2, LazyList.from(3, 2).filter(_.isPrime))
}
