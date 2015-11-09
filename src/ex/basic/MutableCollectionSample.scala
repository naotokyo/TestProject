package ex.basic

import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Set
import scala.collection.mutable.Map

/**
  * Created by naoyuki on 2015/11/09.
  */
object MutableCollectionSample extends App {

  def useListBuffer() = {
    // ミュータブルなListを生成
    val list = ListBuffer("A", "B")
    println(list)
    // 先頭に要素を追加
    "2" +=: list
    println(list)
    // 末尾に要素を追加
    list += "C"
    println(list)
    // 先頭に複数の要素を一度に追加
    List("X", "Y") ++=: list
    println(list)
    // 末尾に複数の要素を一度に追加
    list ++= List("D", "E")
    println(list)
    // インデックスを指定して要素を変更
    list(4) = "B'"
    println(list)
    // 要素を削除
    list -= "A"
    println(list)
    // 複数の要素を一度に削除
    list --= List("C", "D")
    println(list)
    // インデックスを指定して要素を削除
    list.remove(1)
    println(list)
    // Listを空にする
    list.clear()
    println(list)
  }

  def useMutableSet() = {
    // ミュータブルなSetを生成
    val set = Set("A", "B")
    println(set)
    // +=メソッドで要素を追加
    set += "C"
    println(set)
    // addメソッドで要素を追加
    set.add("D")
    println(set)
    // 複数の要素を一度に追加
    set ++= Set("E", "F")
    println(set)
    // -=メソッドで要素を削除
    set -= "A"
    println(set)
    // removeメソッドで要素を削除
    set.remove("B")
    println(set)
    // 複数の要素を一度に削除
    set --= Set("C", "D")
    println(set)
    // Setを空にする
    set.clear()
    println(set)
  }

  def useMutableMap() = {
    // ミュータブルなMapを生成
    val map = Map("key1" -> "value1")
    println(map)
    // putメソッドで要素を追加
    map.put("key2", "value2")
    println(map)
    // +=メソッドで要素を追加
    map += ("key3" -> "value3", "key4" -> "value4")
    println(map)
    // removeメソッドで要素を削除
    map.remove("key1")
    println(map)
    // -=メソッドで要素を削除
    map -= "key2"
    println(map)
    // --=メソッドで複数の要素を一度に削除
    map --= List("key3", "key4")
    println(map)
  }

  useListBuffer()
  useMutableSet()
  useMutableMap()
}
