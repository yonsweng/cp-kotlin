fun main() {
    val t = readln().toInt()
    for (i in 1..t) {
        val l = readln().split(" ").map { it.toInt() }
        val x1 = l[0]
        val y1 = l[1]
        val r1 = l[2]
        val x2 = l[3]
        val y2 = l[4]
        val r2 = l[5]
        val dSquare = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)
        if (dSquare == 0 && r1 == r2) {
            println(-1)
        } else if (dSquare < (r2 - r1) * (r2 - r1) || dSquare > (r1 + r2) * (r1 + r2)) {
            println(0)
        } else if (dSquare == (r2 - r1) * (r2 - r1) || dSquare == (r1 + r2) * (r1 + r2)) {
            println(1)
        } else {
            println(2)
        }
    }
}