package com.todddeluca.fpinscala

/**
 */
object Chapter3 {

  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case x :: xs => f(x, foldRight(xs, z)(f))
    }
  }

  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case x :: xs => foldLeft(xs, f(z, x))(f)
    }
  }
}
