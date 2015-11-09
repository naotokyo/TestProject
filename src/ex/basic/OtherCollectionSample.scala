package ex.basic

/**
  * Created by naoyuki on 2015/11/09.
  */
object OtherCollectionSample extends App {

  def useArray() = {
    // ファクトリメソッドを使用して、要素を2つ持つString型の配列を生成
    val array1 = Array("A", "B")
    println(array1)

    // コンストラクタを使用して、長さを指定して配列を宣言しd、後から要素をセット
    val array2 = new Array[String](2)
    array2(0) = "A"
    array2(1) = "B"
    println(array2)

    // 二次元配列
    val array3 = Array(Array("A", "B"), Array("C", "D"))
    println(array3)
  }

  def useVector() = {
    val vector = Vector("A", "B", "C")

    // インデックスを指定して参照
    val e1 = vector(0)
    println(e1)
    val e2 = vector(1)
    println(e2)
    val e3 = vector(2)
    println(e3)

    // foreachメソッドで繰り返し処理
    vector.foreach { e =>
      println(e)
    }

    // インデックス=1の要素を"*"に置換したVectorを生成
    val newVector = vector.updated(1, "*")
    println(newVector)
  }

  def useTuple() = {
    // 要素を2つ持つタプル
    val user1:(Int, String) = (1, "abc")
    println(user1)
    // Pairという別名を使用して作成
    val user2:(Int, String) = Pair(2, "def")
    println(user2)

    // 要素を3つ持つタプル
    val book1:(String, String, Int) = ("java", "翔泳社", 3700)
    println(book1)
    // Tripleという別名を使用して作成
    val book2:(String, String, Int) = Triple("scala", "翔泳社", 3200)
    println(book2)

    // タプルから値を取得
    val id: Int = user1._1
    println(id)
    val name: String = user1._2
    println(name)

    // タプルから値を分解
    val (bookName: String, publisher: String, price: Int) = book1

    // パターンマッチで値を抽出
    book1 match {
      case (bookName: String, publisher: String, price: Int) => {

      }
    }



  }

  useArray()
  useVector()

}
