package dev.broman.ninetynine.arithmetic

class Arithmetic(val start: Int) {

  import Arithmetic._

  // P31: Check if a given number is prime
  // My original solution worked but I was so caught up in fixing the
  // posted solution that I might as well keep the posted, fixed one
  def isPrime: Boolean =
    (start > 1) && (primes takeWhile {
      _ <= Math.sqrt(start)
    } forall {
      start % _ != 0
    })

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
  def totient: Int = (1 to start) count { start.isCoprimeTo(_) }

  def isPrimeFactorOf(i: Int): Boolean = i.isPrime && start % i == 0

  // P35: Determine the prime factors of a given positive integer
  // can be done simply with a filter on a Range, moving away
  def primeFactors: List[Int] =
    (1 to start) filter {
      _.isPrimeFactorOf(start)
    } toList

  // P36: Determine the prime factors of a given integer and their multiplicity
  def primeFactorsMultiplicity: List[(Int, Int)] = {
    import dev.broman.ninetynine.lists.P10.encode
    encode(start.primeFactors) map { _.swap }
  }

  // P37 (**) Calculate Euler's totient function phi(m) (improved).
  //     See problem P34 for the definition of Euler's totient function.  If the
  //     list of the prime factors of a number m is known in the form of problem
  //     P36 then the function phi(m>) can be efficiently calculated as follows:
  //     Let [[p_1, m_1], [p_2, m_2], [p_3, m_3], ...] be the list of prime
  //     factors (and their multiplicities) of a given number m.  Then phi(m) can
  //     be calculated with the following formula:
  //     phi(m) = (p_1-1)*p_1^(m_1-1) * (p_2-1)*p_2^(m_2-1) * (p_3-1)*p_3^(m_3-1) * ...
  def totientImproved: Int = start.primeFactorsMultiplicity.foldLeft(1) { (acc, i) => {
    i match {
      case (a, b) => acc * (b - 1) * Math.pow(a, b - 1) toInt
    }
  }
  }

  // P38: Test the two different methods
  // Just gonna copy the example code
  def time[A](label: String)(block: => A): A = {
    val now = System.currentTimeMillis()
    val ret = block
    println(label + ": " + (System.currentTimeMillis() - now) + " ms.")
    ret
  }

  def test(n: Int) {
    time("Preload primes") {
      primes takeWhile {
        _ <= Math.sqrt(n)
      } force
    }
    time("P34 (" + n + ")") {
      n.totientImproved
    }
    time("P37 (" + n + ")") {
      n.totient
    }
  }

  // P39: Generate a list of prime numbers in a range
  def listPrimesInRange(r: Range): List[Int] =
    primes dropWhile { _ < r.start } dropWhile { _ > r.last } toList

  // P40
  // Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers.
  // Write a function to find the two prime numbers that sum up to a given even integer.

  def goldbach: (Int, Int) = {
    primes takeWhile(_ < start) find { pp => (start - pp).isPrime } match {
      case None => (-1, -1)
      case Some(e) => (e, start - e)
    }
  }

  // P41: Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.
  // Printed integers cannot be below the floor.
  def printGoldbachList(r: Range, floor: Int = 0): Unit = {
    for(i <- r) {
      val (m, n) = i.goldbach
      if(m >= floor || n >= floor)
        println(f"$i = $m + $n")
    }
  }
}

object Arithmetic {
  implicit def intArithmetic(i: Int): Arithmetic = new Arithmetic(i)
  val primes = LazyList.cons(2, LazyList.from(3, 2).filter(_.isPrime))
}
