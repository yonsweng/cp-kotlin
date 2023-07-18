fun printSequence(n: Int, m: Int, sequence: Array<Int>, used: BooleanArray) {
    if (m == 0) {
        println(sequence.joinToString(" "))
        return
    }
    for (i in 1..n) {
        if (used[i - 1]) continue
        used[i - 1] = true
        sequence[sequence.size - m] = i
        printSequence(n, m - 1, sequence, used)
        used[i - 1] = false
    }
}

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    printSequence(n, m, Array(m) { 0 }, BooleanArray(n))
}