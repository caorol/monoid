package org.pankuzu.book.fpinscala.c10.exercise

import org.pankuzu.book.fpinscala.c10.Monoid

/**
  * 整数の加算/乗算、論理演算子に対するMonoidインスタンスを作成する
  * val intAddition: Monoid[Int]
  * val intMultiplication: Monoid[Int]
  * val booleanOr: Monoid[Boolean]
  * val booleanAnd: Monoid[Boolean]
  */
object E_10_1 extends App {
  val intAddition: Monoid[Int] = new Monoid[Int] {
    override def op(x: Int, y: Int): Int = x + y
    override def zero: Int = 0
  }
  println(intAddition.op(1, 2))
  
  val intMultiplication: Monoid[Int] = new Monoid[Int] {
    override def op(x: Int, y: Int): Int = x * y
    override def zero: Int = 0
  }
  println(intMultiplication.op(2, 3))
  
  val booleanOr: Monoid[Boolean] = new Monoid[Boolean] {
    override def op(x: Boolean, y: Boolean): Boolean = x || y
    override def zero: Boolean = false
  }
  println(booleanOr.op(false, false))
  println(booleanOr.op(true, false))
  println(booleanOr.op(false, true))
  println(booleanOr.op(true, true))
  
  val booleanAnd: Monoid[Boolean] = new Monoid[Boolean] {
    override def op(x: Boolean, y: Boolean): Boolean = x && y
    override def zero: Boolean = true
  }
  println(booleanAnd.op(false, false))
  println(booleanAnd.op(true, false))
  println(booleanAnd.op(false, true))
  println(booleanAnd.op(true, true))
}


