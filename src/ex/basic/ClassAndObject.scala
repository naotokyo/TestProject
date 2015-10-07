package ex.basic

/**
 * @author Naoyuki Hirata
 */
object ClassAndObject extends App {
  val s1 = new Syouhin("S001", 1000)
  val s2 = new Syouhin("S002", 2980)

  s2.price -= 200
  s1.disp()
  s2.disp()
  println(Calc.kingaku(s1, 10))
  println(Calc.kingaku(s2, 5))
}


object Calc {
  def kingaku(s: Syouhin, n: Int) = {
    (s.price * n * 1.08).toInt
  }
}

class Syouhin(val code: String = "0000", var price: Int = 0) {
  def disp() {
    println(code + " " + price + "円")
  }

  disp()
}