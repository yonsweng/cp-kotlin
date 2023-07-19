fun main() {
    val n = readln().toInt()
    val points = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        points.add(Pair(x, y))
    }
    points.sortWith(compareBy({ it.second }, { it.first }))
    points.forEach { println("${it.first} ${it.second}") }
}