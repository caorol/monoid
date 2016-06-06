package org.pankuzu.book.fpinscala.c10.exercise

import org.pankuzu.book.fpinscala.c10.Monoid

/**
  * Monoid インスタンスを持たない要素型がリストに含まれている場合
  * -> リストにマッピング（map）すれば Monoid インスタンスを持つ型にいつでも変換できる
  * foldMap を実装する
  * 
  * def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B
  */
object E_10_5 extends App {
  val stringMonoid = new Monoid[String] {
    def op(x: String, y: String) = x + y
    def zero = ""
  }
  def toString(x: Int) = x.toString
  
  def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B = {
//    as.map((a, b) => m.op(f(a), f(b)))
    as.foldLeft(m.zero)((b, a) => m.op(b, f(a)))
  }
  println(foldMap(List(1, 2, 3, 4, 5), stringMonoid)((x: Int) => x.toString))
}
