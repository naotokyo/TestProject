package ex.basic

import scala.collection.SortedMap

/**
 * Created by naoyuki on 15/11/08.
 */
object MapSample extends App {

  def createAndGet() = {
    // 空のMapを作成
    val emptyMap: Map[Int, String] = Map()
    // 指定したキーと値を持つMapを作成
    val map = Map("key1" -> "value1", "key2" -> "value2")

    // Option型で値を取得
    val get1 = map.get("key1")
    println(get1)
    val get2 = map.get("key2")
    println(get2)
    val get3 = map.get("key3")
    println(get3)

    // キーがない場合の値を指定して取得
    val getOrElse1 = map.getOrElse("key1", "")
    println(getOrElse1)
    val getOrElse2 = map.getOrElse("key2", "")
    println(getOrElse2)
    val getOrElse3 = map.getOrElse("key3", "")
    println(getOrElse3)

    // 値を直接取得できる
    val value1 = map("key1")
    println(value1)
    val value2 = map("key2")
    println(value2)
//    val value3 = map("key3")  // => java.util.NoSuchElementException

    // Mapにキーが含まれているかどうか調べる
    val contains1 = map.contains("key1")
    println(contains1)
    val contains3 = map.contains("key3")
    println(contains3)
  }

  def loop() = {
    val map = Map("key1" -> "value1", "key2" -> "value2")

    // Mapの要素を繰り返し処理
    map.foreach { e =>
      println(e._1 + "=" + e._2)
    }

    map.foreach { case(key, value) =>
      println(key + "=" + value)
    }
  }

  def append() = {
    val map = Map("key1" -> "value1", "key2" -> "value2")

    // 要素を追加した新しいMapを作成
    val newMap = map + ("key3" -> "value3", "key4" -> "value4")
    println(newMap)
  }

  def concat() = {
    // MapとMapを連結
    val map1 = Map("key1" -> "value1") ++ Map("key2" -> "value2")
    println(map1)

    // MapとListを連結
    val map2 = Map("key1" -> "value1") ++ List(("key2", "value2"))
    println(map2)

    // ListとMapを連結（左辺がMap以外の場合は++:メソッドを使用する）
    val map3 = List(("key1", "value1")) ++: Map("key2" -> "value2")
    println(map3)
  }

  def delete() = {
    val map = Map(
      "key1" -> "value1",
      "key2" -> "value2",
      "key3" -> "value3",
      "key4" -> "value4"
    )

    // 指定したキーを削除した新しいMapを作成
    val removedMap1 = map - "key1"
    println(removedMap1)

    // 複数のキー（タプルで指定）を削除した新しいMapを作成
    val removedMap2 = map - ("key2", "key3")
    println(removedMap2)

    // 複数のキー（コレクションで指定）を削除した新しいMapを作成
    val removedMap3 = map -- List("key1", "key2")
    println(removedMap3)
  }

  def convert() = {
    val books = Map(
      1 -> "Java",
      2 -> "Ruby",
      3 -> "Node.js"
    )

    // 要素の値を変換した新しいMapを作成
    val result1 = books.map { case(key, value) =>
      (key, "「" + value + "」")
    }
    println(result1)

    // 要素を別のオブジェクトに変換
    case class Book(id: Int, name: String)

    // Bookを要素に持つIterableを作成
    val result2 = books.map { case(key, value) =>
        Book(key, value)
    }
    println(result2)
  }

  def sort() = {
    val books = Map(
      2 -> "Ruby",
      1 -> "Java",
      3 -> "Node.js"
    )

    // ソートされたキーのList
    val sortedKeys = books.keys.toList.sorted

    // キーの昇順で繰り返し処理
    sortedKeys.foreach { key =>
      println("%d: %s".format(key, books(key)))
    }

    val books2 = SortedMap(
      2 -> "Ruby",
      1 -> "Java",
      3 -> "Node.js"
    )

    books2.foreach { case(key, value) =>
        println("%d: %s".format(key, value))
    }
  }

  createAndGet()
  loop()
  append()
  delete()
  convert()
  sort()
}
