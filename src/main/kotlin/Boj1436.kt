fun main() {
    val n = readln().toInt()
    var count = 0
    for (i in 666..Int.MAX_VALUE) {
        if (i.toString().contains("666")) {
            if (++count == n) {
                println(i)
                break
            }
        }
    }
}