package CaseClassAndPatternMatching

object TreeProblem {

  def max(tree: Tree): Int = {
    tree match {
      case Branch(v, Empty, Empty) =>
        v
      case Branch(v, Empty, r) =>
        val x = max(r)
        if(v > x) v else x
      case Branch(v, l, Empty) =>
        val x = max(l)
        if(v > x) v else x
      case Branch(v, l, r) =>
        val x = max(l)
        val y = max(r)
        if(v > x) {
          if(v > y) v else y
        } else {
          if(x > y) x else y
        }
      case Empty =>
        throw new RuntimeException
    }
  }

  def min(tree: Tree): Int = {
    tree match {
      case Branch(v, Empty, Empty) =>
        v
      case Branch(v, Empty, r) =>
        val x = min(r)
        if (v < x) v else x
      case Branch(v, l, Empty) =>
        val x = min(l)
        if (v < x) v else x
      case Branch(v, l, r) =>
        val x = min(l)
        val y = min(r)
        if (v < x) {
          if (v < y) v else y
        } else {
          if (x < y) x else y
        }
      case Empty =>
        throw new RuntimeException
    }
  }

  def depth(tree: Tree): Int = {
    tree match {
      case Branch(_, l, r) =>
        val x = depth(l)
        val y = depth(r)
        if (x > y) x+1 else y+1
      case Empty =>
        0
    }
  }

  def insert(value: Int, t: Tree): Tree = {
    t match {
      case Empty => Branch(value, Empty, Empty)
      case Branch(v, l, r) =>
        if (value <= v) Branch(v, insert(value, l), r)
        else Branch(v, l, insert(value, r))
    }
  }

  def fromList(list: List[Int]): Tree = {
    list.foldLeft(Empty:Tree){ case (t, v) => insert(v, t) }
  }

  def toList(tree: Tree): List[Int] = {
    tree match {
      case Empty => Nil
      case Branch(v, l, r) => toList(l) ++ List(v) ++ toList(r)
    }
  }

  def sort(t: Tree): Tree = {
    fromList(toList(t))
  }

  def main(args: Array[String]): Unit = {
    // using tree
    val t = Branch(
      10,
      Branch(
        20,
        Empty,
        Empty
      ),
      Branch(
        30,
        Branch(
          40,
          Empty,
          Empty
        ),
        Empty
      )
    )

    // Check max
    println(max(t))
    // Check min
    println(min(t))
    // Check depth
    println(depth(t))
    // Check sort
    println(sort(t))
  }

}
