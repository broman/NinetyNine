package dev.broman.ninetynine.logic

object Logic {
  def and(op1: Boolean, op2: Boolean): Boolean = {
    // T & T = T, else F
    (op1, op2) match {
      case (true, true) => true
      case _ => false
    }
  }

  def not(op1: Boolean): Boolean = {
    if (op1) false
    else true
  }

  def nand(op1: Boolean, op2: Boolean): Boolean = {
    (op1, op2) match {
      case (true, true) => false
      case _ => true
    }
  }
}
