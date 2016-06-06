package org.pankuzu.book.fpinscala.c10

// モノイドによるリストの畳み込み
object C_10_2 extends App {
  // List の foldLeft, foldRight のシグネチャ
  /*
  def foldRight[B](z: B)(f: (A, B) => B): B
  def foldLeft[B](z: B)(f: (B, A) => B): B
  */
  // A と B が同じ型だとすると、モノイドのコンポーネントと一致する
  /*
  def foldRight[A](z: A)(f: (A, A) => A): A
  def foldLeft[A](z: A)(f: (A, A) => A): A
  */
  val stringMonoid = new Monoid[String]{
    def op(x: String, y: String) = x + y
    def zero = ""
  }
  val words = List("Hic", "Est", "Index")
  val s = words.foldRight(stringMonoid.zero)(stringMonoid.op)
  val t = words.foldLeft(stringMonoid.zero)(stringMonoid.op)
  // 結合律と同一律が適用されるからどちらから折りたたんでも結果は同じ
  println(s)
  println(t)
  
  // 10-4 モノイドを使ってリストを畳み込む総称関数concatenate
  def concatenate[A](as: List[A], m: Monoid[A]): A = as.foldLeft(m.zero)(m.op)
  println(concatenate(List("aaa", "bbb", "ccc"), stringMonoid))

  // Monoid インスタンスを持たない要素型がリストに含まれている場合
  // -> リストにマッピング（map）すれば Monoid インスタンスを持つ型にいつでも変換できる
  //def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B
}
