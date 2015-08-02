package com.todddeluca.fpinscala


import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, FunSuite}
import org.scalatest.junit.JUnitRunner

import Chapter3._

@RunWith(classOf[JUnitRunner])
class Chapter3Test extends FunSuite {


  test("length implemented with foldRight") {
    assert(length(List()) === 0)
    assert(length(List("a")) === 1)
    assert(length(List(1,2,3)) === 3)
  }

  test("foldRight will overflow the stack for large lists") {
    intercept[StackOverflowError] {
      foldRight((0 until 10000).toList, 0)(_ + _)
    }
  }

  test("foldRight leaves list unchanged when used with Cons and Nil") {
    assert(foldRight(List(1,2,3), Nil: List[Int])((a, b) => a :: b) === List(1,2,3))
  }

  test("foldLeft reverses lists with Cons and Nil") {
    assert(foldLeft(List(1,2,3), Nil: List[Int])((b, a) => a :: b) === List(3,2,1))
  }

  test("foldRight2 will not overflow the stack for large lists") {
    foldRight2((0 until 10000).toList, 0)(_ + _)
  }

  test("foldRight2 leaves list unchanged when used with Cons and Nil") {
    assert(foldRight2(List(1,2,3), Nil: List[Int])((a, b) => a :: b) === List(1,2,3))
  }

  test("foldLeft2 reverses lists with Cons and Nil") {
    assert(foldLeft2(List(1,2,3), Nil: List[Int])((b, a) => a :: b) === List(3,2,1))
  }

  test("foldLeft2 overflows the stack for large lists") {
    intercept[StackOverflowError] {
      foldLeft2((0 until 10000).toList, 0)(_ + _)
    }
  }

  test("Appending an element to a list adds it to the back of the list") {
    assert(append(List(1,2), 3) === List(1,2,3))
    assert(append(Nil, 3) === List(3))
  }

}

@RunWith(classOf[JUnitRunner])
class Chapter3Test2 extends FlatSpec {
  "A reversed list" should "have its elements reversed" in {
    assert(reverse(List(1,2,3)) === List(3,2,1))
  }


}

