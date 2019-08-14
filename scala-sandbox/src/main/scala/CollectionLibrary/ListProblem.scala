package CollectionLibrary

object ListProblem {

  def joinByComma(start:Int, end:Int): String = {
    (start to end).mkString(",")
  }

  def reverse[T](list:List[T]): List[T] = {
    list.foldLeft(Nil:List[T])( (a, b) => b :: a )
  }

  def sum(list:List[Int]): Int = {
    list.foldRight(0){ (x, y) => x + y }
  }

  def mul(list:List[Int]): Int = {
    list.foldRight(1){ (x, y) => x * y }
  }

  def mkString[T](list:List[T])(sep:String): String = {
    list match  {
      case Nil => ""
      case x::xs => xs.foldLeft(x.toString){ (x, y) => x + sep + y }
    }
  }

  def map[T, U](list:List[T])(f:T => U): List[U] = {
    list.foldLeft(Nil:List[U]){(x, y) => f(y) :: x}.reverse
  }

  def filter[T](list:List[T])(f:T => Boolean): List[T] = {
    list.foldLeft(Nil:List[T]){ (x, y) => if(f(y)) { y :: x } else {x} }.reverse
  }

  def count[T](list: List[T])(f: T => Boolean): Int = {
    list.foldLeft(0){ (x, y) => if(f(y)) x+1 else x }
  }

  def main(args: Array[String]): Unit = {
    // Check joinByComma
    println(joinByComma(1, 10))
    // Check reverse
    println(reverse((1 to 10).toList))
    // Check sum
    println(sum((1 to 10).toList))
    // Check mul
    println(mul((1 to 10).toList))
    // Check mkString
    println(mkString((1 to 10).toList)(","))
    // Check map
    println(map((1 to 10).toList){(x => x*1.0)})
    // Check filter
    println(filter((1 to 10).toList){(x => x%2 == 0)})
    // Check count
    println(count((1 to 10).toList){(x => x%2 == 0)})
  }

}
