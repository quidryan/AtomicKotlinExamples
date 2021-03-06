// Coroutines/FibonacciSequence.kt
import atomictest.eq
import bigint.*
import kotlin.coroutines.experimental.*

fun main(args: Array<String>) {
  val fibonacciSeq = buildSequence {
    var n = Pair(zero, one)
    while (true) {
      yield(n.first)
      n = Pair(n.second, n.first + n.second)
    }
  }
  fibonacciSeq.take(101).last() eq
    "354224848179261915075".big
}
