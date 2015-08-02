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

  def length[A](as: List[A]): Int = foldRight[A,Int](as, 0) { (a, i) => i + 1 }

  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {
    as match {
      case Nil => z
      case x :: xs => foldLeft(xs, f(z, x))(f)
    }
  }

  def length2[A](as: List[A]): Int = foldLeft[A, Int](as, 0)((b, a) => b + 1)

  def sum(as: List[Int]): Int = foldLeft(as, 0)(_ + _)

  def product(as: List[Double]): Double = foldLeft(as, 1.0)(_ * _)

  def reverse[A](as: List[A]): List[A] = foldLeft(as, Nil: List[A])((b, a) => a :: b)

  def foldRight2[A,B](as: List[A], z: B)(f: (A, B) => B) = foldLeft(reverse(as), z)((b, a) => f(a, b))

  def foldLeft2[A,B](as: List[A], z: B)(f: (B, A) => B) = {
    foldRight(as, (b: B) => b)((a, c) => (b: B) => c(f(b, a)))(z)
  }

  def reverse2[A](as: List[A]): List[A] = foldRight(as, Nil: List[A])((a, b) => a :: b)

  def append[A](as: List[A], a: A): List[A] = foldRight(as, List(a))(_ :: _)

  def prepend[A](as: List[A], as2: List[A]) = foldRight(as, as2)(_ :: _)

  def flattenLists[A](ass: List[List[A]]): List[A] = foldRight(ass, Nil: List[A])(prepend)
}
