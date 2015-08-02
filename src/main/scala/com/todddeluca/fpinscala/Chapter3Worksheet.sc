package com.todddeluca.fpinscala

object Chapter3Worksheet {
  import Chapter3._

  val b = foldLeft(List(1,2,3), 1)(_ * _)
  val i: Int = 1

  // reverse
  val c = foldLeft(List(1,2,3), Nil: List[Int])((b, a) => a :: b)
  // copy
  val d = foldRight(List(1,2,3), Nil: List[Int])((a, b) => a :: b)

}