package net.zero918nobita.smilepp.frontend

class Variable(private val name: String): Node() {
  override fun equals(other: Any?) =
          (other is Variable) && (name == other.name)

  override fun hashCode() = name.hashCode()

  override fun toString() = name
}
