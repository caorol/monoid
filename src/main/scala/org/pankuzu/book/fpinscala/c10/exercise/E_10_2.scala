package org.pankuzu.book.fpinscala.c10.exercise

import org.pankuzu.book.fpinscala.c10.Monoid

/**
  * Option 型の値を結合するための Monoid インスタンス
  * def optionMonoid[A]: Monoid[Option[A]]
  */
object E_10_2 extends App {
  def optionMonoid[A]: Monoid[Option[A]] = new Monoid[Option[A]] {
    override def op(x: Option[A], y: Option[A]): Option[A] = x orElse y
    override def zero: Option[A] = None
  }
  println(optionMonoid)
  println(optionMonoid.op(Some("abc"), Some("def")))
  println(optionMonoid.op(optionMonoid.zero, Some("def")))

  def dual[A](m: Monoid[A]): Monoid[A] = new Monoid[A] {
    override def op(x: A, y: A): A = m.op(y, x)
    override def zero: A = m.zero
  }
  def firstOptionMonoid[A]: Monoid[Option[A]] = optionMonoid[A]
  def lastOptionMonoid[A]: Monoid[Option[A]] = dual(firstOptionMonoid)

  println(firstOptionMonoid.op(Some("abc"), Some("def")))
  println(firstOptionMonoid.op(firstOptionMonoid.zero, Some("def")))

  println(lastOptionMonoid.op(Some("abc"), Some("def")))
  println(lastOptionMonoid.op(lastOptionMonoid.zero, Some("def")))

}

