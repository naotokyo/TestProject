package ex.partiallyappliedfunction

object PartiallyAppliedFunction4 extends App {
  val data = List(
    "S01,25,165.0,54.1",
    "S02,23,173.5,55.5",
    "S03,30,169.2,75.0",
    "S04,41,172.6,79.5")

  // 文字列データから各データ型のダブルとして返す
  def parseData(s: String) = {
    val t = s.split(",")
    (t(0), t(1).toInt, t(2).toDouble, t(3).toDouble)
  }

  // BMI測定を行う
//  def bmi(t: Double, w: Double) = {
  def bmi(t: Double, w: Double, a: Int ) = {  // 引数に年齢を追加
//    val base = Array(18.5, 25.0, 30.0)
    val base = if (a < 40) Array(18.5, 25.0, 30.0) else Array(23.0, 27.0, 30.0)  // 40才以上用の基準
    val t1 = t * 0.01
    val x = w / (t1 * t1)
    if (x < base(0)) {
      "やせ型"
    } else if (x < base(1)) {
      "普通"
    } else if (x < base(2)) {
      "肥満"
    } else {
      "高度肥満"
    }
  }

  // 出力メソッド
  def hyouji(code: String, a: Int, t: Double, w: Double, fun: (Double, Double) => String) = {
    printf("--------------------\n")
    printf("社員コード:%s\n", code)
    printf("  年齢\t= %2d  才\n", a)
    printf("  身長\t= %4.1f  cm\n", t)
    printf("  体重\t= %4.1f  kg\n", w)
    printf("  判定\t= %s\n", fun(t, w))
  }

  def test() {
    for (s <- data) {
      val d = parseData(s)
      val bmiFun = bmi(_: Double, _: Double, d._2)  // 年齢を部分適用
//      hyouji(d._1, d._2, d._3, d._4, bmi)
      hyouji(d._1, d._2, d._3, d._4, bmiFun)  // 部分適用した関数を渡す（hyouji内の変更なし）
    }
  }

  test()
}