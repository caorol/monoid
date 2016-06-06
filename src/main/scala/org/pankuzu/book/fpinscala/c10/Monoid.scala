package org.pankuzu.book.fpinscala.c10

// 10-1
trait Monoid[A]{
  def op(a1: A, a2: A): A
  def zero: A
}

