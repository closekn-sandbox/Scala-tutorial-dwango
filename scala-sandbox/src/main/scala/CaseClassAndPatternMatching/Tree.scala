package CaseClassAndPatternMatching

sealed abstract class Tree

case class Branch(value: Int, left: Tree, right: Tree) extends Tree
case object Empty extends Tree
