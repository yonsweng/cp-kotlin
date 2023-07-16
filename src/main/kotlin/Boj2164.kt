fun main() {
    val n = readln().toInt()
    val ad = ArrayDeque((1..n).toList())
    while (ad.size > 1) {
        ad.removeFirst()
        ad.addLast(ad.removeFirst())
    }
    println(ad.first())
}