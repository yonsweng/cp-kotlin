import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.ArrayDeque

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val deque = ArrayDeque<Int>()
    for (i in 1..n) {
        val cmd = br.readLine().split(" ")
        when (cmd[0]) {
            "push_front" -> deque.addFirst(cmd[1].toInt())
            "push_back" -> deque.addLast(cmd[1].toInt())
            "pop_front" -> bw.write((if (deque.isEmpty()) -1 else deque.removeFirst()).toString() + "\n")
            "pop_back" -> bw.write((if (deque.isEmpty()) -1 else deque.removeLast()).toString() + "\n")
            "size" -> bw.write(deque.size.toString() + "\n")
            "empty" -> bw.write((if (deque.isEmpty()) 1 else 0).toString() + "\n")
            "front" -> bw.write((if (deque.isEmpty()) -1 else deque.first).toString() + "\n")
            "back" -> bw.write((if (deque.isEmpty()) -1 else deque.last).toString() + "\n")
        }
    }
    bw.flush()
    bw.close()
}