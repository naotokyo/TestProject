package ex.basic

import scala.collection.immutable.SortedSet


/**
  * Created by naoyuki on 2015/11/09.
  */
object SetSample extends App {

  def crud() = {

    // Setを生成
    val set: Set[String] = Set("A", "B", "C", "D")

    // 要素が含まれているかの確認
    if (set.contains("A")) {
      println("Aが含まれています。")
    }

    // 要素の繰り返し処理
    set.foreach {
      println(_)
    }

    // 要素を変換
    val result: Set[Int] = set.map { _.length }
    println(result)

    // 要素を追加した新しいSetを生成
    val set2 = set + "E"
    println(set2)
    // 複数の要素を一度に追加
    val set3 = set ++ Set("F", "G")
    println(set3)

    // 要素を削除した新しいSetを生成
    val set4 = set - "A"
    println(set4)
    // 複数の要素を一度に削除
    val set5 = set -- Set("B", "C")
    println(set5)

    // 要素をフィルタリング("E"以外を抽出)
    val set6 = set.filter { _ != "E" }
    println(set6)
  }

  def calc() = {
    val set1 = Set(1, 2, 3)
    val set2 = Set(2, 3, 4)

    // 積集合（set1とset2の両方に含まれている要素から成るSet）
    println(set1 & set2)

    // 和集合（set1とset2のいずれかに含まれている要素から成るSet
    println(set1 | set2)

    // 差集合（set1のうちset2に含まれていない要素から成るSet
    println(set1 &~ set2)
  }

  def sort() = {
    // ソート済みのSetを生成
    val sortedSet = SortedSet(2, 4, 3, 1)
    // 1, 2, 3, 4の順で表示される
    sortedSet.foreach { println _ }
  }

  crud()
  calc()
  sort()
}
