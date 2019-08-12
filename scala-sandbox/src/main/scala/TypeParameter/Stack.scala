package TypeParameter

trait Stack[+A] {
  def push[E >: A](e: E): Stack[E]
  def top: A
  def pop: Stack[A]
  def isEmpty: Boolean
}

object Stack {
  def apply(): Stack[Nothing] = EmptyStack
}

