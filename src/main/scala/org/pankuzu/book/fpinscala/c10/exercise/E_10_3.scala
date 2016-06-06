package org.pankuzu.book.fpinscala.c10.exercise

import org.pankuzu.book.fpinscala.c10.Monoid

/**
  * 引数及び戻り値の値の型が同じである関数を endo関数（endofunction）と呼ぶことがある
  * endo関数のモノイドを記述せよ
  * def endoMonoid[A]: Monoid[A => A]
  */
object E_10_3 extends App {
  def endoMonoid[A]: Monoid[A => A] = new Monoid[(A) => A] {
    override def op(x: (A) => A, y: (A) => A): (A) => A = ???
    override def zero: (A) => A = ???
  }
}
