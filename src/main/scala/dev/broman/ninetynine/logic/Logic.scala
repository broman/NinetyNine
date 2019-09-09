package dev.broman.ninetynine.logic

class Logic(op1: Boolean) {
  import Logic._
  def and(op1: Boolean, op2: Boolean): Boolean = {
    (op1, op2) match {
      case (true, true) => true
      case _ => false
    }
  }

  def or(op1: Boolean, op2: Boolean): Boolean = {
    (op1, op2) match {
      case (true, _) => true
      case (_, true) => true
      case _ => false
    }
  }

  def not(op1: Boolean): Boolean = {
    if (op1) false
    else true
  }

  // equals is just if a && b or !a && !b
  def equ(op1: Boolean, op2: Boolean): Boolean = or(and(op1, op2), and(not(op1), not(op2)))
  def xor(op1: Boolean, op2: Boolean): Boolean = not(equ(op1, op2))
  def nor(op1: Boolean, op2: Boolean): Boolean = not(or(op1, op2))
  def nand(op1: Boolean, op2: Boolean): Boolean = {
    (op1, op2) match {
      case (true, true) => false
      case _ => true
    }
  }
  def impl(op1: Boolean, op2: Boolean): Boolean = or(not(op1), op2)

  def table(f: (Boolean, Boolean) => Boolean): Unit =
    for(op1 <- List(true, false); op2 <- List(true, false))
      println(s"$op1\t$op2\t${f(op1, op2)}")
}

object Logic {
  // implicitly convert arguments from boolean to the logic class
  implicit def booleanLogic(op1: Boolean): Logic = new Logic(op1)
}
