fun main() {
    while (true) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        if (a == 0 && b == 0 && c == 0) break
        val max = maxOf(a, b, c)
        val min = minOf(a, b, c)
        val mid = a + b + c - max - min
        if (max * max == min * min + mid * mid) println("right")
        else println("wrong")
    }
}