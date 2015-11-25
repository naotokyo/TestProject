package ex.basic

object ListExercises extends App {

  val list = List(1, 1, 2, 3, 5, 8)
  println("last(List(1, 1, 2, 3, 5, 8))=" + last(list))
  println("penultimate(List(1, 1, 2, 3, 5, 8))=" + penultimate(list))
  println("nth(2, List(1, 1, 2, 3, 5, 8))=" + nth(2, list))
  println("length(List(1, 1, 2, 3, 5, 8))=" + length(list))
  println("reverse(List(1, 1, 2, 3, 5, 8))=" + reverse(list))
  println("isPalindrome(List(1, 2, 3, 2, 1))=" + isPalindrome(List(1, 2, 3, 2, 1)))
  println("duplicate(List('a, 'b, 'c, 'c, 'd))=" + duplicate(List('a, 'b, 'c, 'c, 'd)))


  // 1. リストの最後の要素を返す関数 last を作成して下さい
  // scala> last(List(1, 1, 2, 3, 5, 8))
  // res0: Int = 8
  def last[A](ls: List[A]): A = ls match {
    // リストの最後の要素に到達したらその要素を返す
    case x :: Nil => x
    // リストに2つ以上要素がある場合は尾部の last を返す
    case x :: xs => last(xs)
    // それ以外 (Nil) の場合例外を投げる
    case _ => throw new NoSuchElementException
  }

  // 2. リストの最後から2番目の要素を返す関数 penultimate を作成して下さい
  // scala> penultimate(List(1, 1, 2, 3, 5, 8))
  // res0: Int = 5
  def penultimate[A](ls: List[A]): A = ls match {
    // 2要素のリストの場合は，最後から2番目 (先頭) の要素を返す
    case x :: y :: Nil => x
    // 要素数が2, 0でないリストの場合，尾部の penultimate を返す
    case x :: xs => penultimate(xs)
    // それ以外 (Nil) の場合例外を投げる
    case _ => throw new NoSuchElementException
  }

  // 3. リストの n 番目の要素を返す関数 nth を作成して下さい
  // scala> nth(2, List(1, 1, 2, 3, 5, 8))
  // res0: Int = 2
  def nth[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, x :: _) => x
    case (n, x :: xs) => nth(n - 1, xs)
    case (_, Nil) => throw new NoSuchElementException
  }

  // 4. リストの長さを返す関数 length を作成して下さい
  // scala> length(List(1, 1, 2, 3, 5, 8))
  // res0: Int = 6
  def length[A](ls: List[A]): Int = ls match {
    case x :: xs => 1 + length(xs)
    case Nil => 0
  }

  // 5. 入力のリストを，逆順に並べてできるリストを返す関数 reverse を作成して下さい
  // scala> reverse(List(1, 1, 2, 3, 5, 8))
  // res0: List[Int] = List(8, 5, 3, 2, 1, 1)
  def reverse[A](ls: List[A]): List[A] = ls match {
    case x :: xs => reverse(xs) ::: x :: Nil
    case Nil => ls
  }

  // 6. 与えられたリストが回文になっている場合真を，そうでない場合に偽を返す関数 isPalindrome を作成して下さい
  // scala> isPalindrome(List(1, 2, 3, 2, 1))
  // res0: Boolean = true
  def isPalindrome[A](ls: List[A]): Boolean = {
    def _isPalindrome(lhs: List[A], rhs: List[A]): Boolean = (lhs, rhs) match {
      case (x :: xs, y :: ys) if x == y => _isPalindrome(xs, ys)
      case (Nil, Nil) => true
      case _ => false
    }
    _isPalindrome(ls, reverse(ls))
  }

  // 7. 入力のリストの要素を，先頭から2つづつ並べてできるリストを返す関数 duplicate を作成して下さい
  // scala> duplicate(List('a, 'b, 'c, 'c, 'd))
  // res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  def duplicate[A](ls: List[A]): List[A] = ls match {
    case x :: xs => x :: x :: duplicate(xs)
    case _ => Nil
  }

  // 8. リストを指定した位置で分割し，前半部分のリストと後半部分リストの組を返す関数 split を作成して下さい
  // scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  // res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
//  def split[A](n: Int, ls: List[A]): (List[A], List[A]) = ???
//
//  // 9. 入力のリストから，指定した位置の要素を除外して得られるリストと除外した要素の組を返す関数 removeAt を作成してください
//  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ???
//
//  // 10. リストの指定した位置に要素を挿入してできたリストを返す関数 insertAt を作成して下さい
//  def insertAt[A](v: A, n: Int, ls: List[A]): List[A] = ???
//
//  // 11. 2つの数 M, N に対して， M, M+1, ..., N-1 を並べたリストを返す関数 range を作成して下さい
//  def range(start: Int, end: Int): List[Int] = ???
}
