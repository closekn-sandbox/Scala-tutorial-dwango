package Function

import scala.io.Source

object CatFile {

  def withFile[A](filename:String)(f:Source => A):A = {
    val s = Source.fromFile(filename)
    try {
      f(s)
    } finally {
      s.close()
    }
  }

  def printFile(filename:String):Unit = {
    withFile(filename) {
      file => file.getLines.foreach(println)
    }
  }

  def main(args: Array[String]): Unit = {
    val fname = "./test.txt"
    printFile(fname)
  }

}
