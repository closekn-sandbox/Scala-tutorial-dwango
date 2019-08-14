package CollectionLibrary

object ArrayProblem {

  def swapArray[T](arr:Array[T])(i:Int, j:Int): Unit = {
    val tmp = arr(i)
    arr(i) = arr(j)
    arr(j) = tmp
  }

  def printArray[T](arr:Array[T]): Unit = {
    print("[ ")
    for (i <- 0 until arr.length) {
      print(arr(i) + " ")
    }
    println("]")
  }

  def main(args: Array[String]): Unit = {
    val sampleArray = Array(1, 2, 3, 4, 5)
    printArray(sampleArray)
    swapArray(sampleArray)(1, 3)
    printArray(sampleArray)
  }

}
