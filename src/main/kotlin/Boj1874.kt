import java.util.*

fun main() {
    val n = readln().toInt()
    val stack = Stack<Int>()
    var m = 1
    val answer = mutableListOf<Char>()
    for (i in 1..n) {
        val x = readln().toInt()
        while (stack.empty() || stack.peek() != x) {
            stack.push(m++)
            answer.add('+')
            if (m > n + 1) {
                println("NO")
                return
            }
        }
        if (stack.isNotEmpty()) {
            stack.pop()
            answer.add('-')
        }
    }
    answer.forEach { println(it) }
}