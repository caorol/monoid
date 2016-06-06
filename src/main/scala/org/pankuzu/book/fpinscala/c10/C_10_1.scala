package org.pankuzu.book.fpinscala.c10

// モノイドとは
object C_10_1 extends App {
  
  // 10-2 String モノイド
  val stringMonoid = new Monoid[String] {
    def op(a1: String, a2: String) = a1 + a2
    val zero = ""
  }
  println(stringMonoid.zero)
  println(stringMonoid.op("abc", "def"))

  // 10-3 List モノイド
  def listMonoid[A] = new Monoid[List[A]] {
    def op(a1: List[A], a2: List[A]) = a1 ++ a2
    val zero = Nil
  }
  println(listMonoid.zero)
  println(listMonoid[String].op(List("ab", "cd"), List("ef")))
  println(listMonoid[Int].op(List(1,2), listMonoid.zero))
}

