package Object

class Test(private val point:Int) {

}

object Test {
  def main(args: Array[String]): Unit = {
    val t = new Test(75)
    println(t.point)
  }
}