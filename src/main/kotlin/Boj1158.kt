fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val list = (1..n).toMutableList()
    var index = 0
    val result = mutableListOf<Int>()
    while (list.isNotEmpty()) {
        index = (index + k - 1) % list.size
        result.add(list.removeAt(index))
    }
    println("<${result.joinToString(", ")}>")
}