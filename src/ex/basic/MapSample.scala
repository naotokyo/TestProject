package ex.basic

/**
 * Created by naoyuki on 15/11/08.
 */
object MapSample extends App {

  def createAndGet = {
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

  createAndGet()


}
