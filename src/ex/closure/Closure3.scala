package ex.closure

object Closure3 extends App {

  def menseki(v: Double) = {
    val pi = v
    (r: Double) => {
      r * r * pi
    }
  }

  def test1() {
    println("¥n=== e円の面積（πの精度:3）===¥n")
    val f1 = menseki(3)
    println(f1(2))
    println(f1(3))
    println(f1(4))
  }

  def test2() {
    println("¥n=== e円の面積（πの精度:3.141592）===¥n")
    val f2 = menseki(3.141592)
    println(f2(2))
    println(f2(3))
    println(f2(4))
  }

  test1()
  test2()
}