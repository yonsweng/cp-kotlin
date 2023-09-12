

fun main() {
    val l = readln().split(" ").map { it.toInt() }
    val h1 = l[0]
    val m1 = l[1]
    val s1 = l[2]
    val h2 = l[3]
    val m2 = l[4]
    val s2 = l[5]

    var t1 = h1 * 3600 + m1 * 60 + s1
    var t2 = h2 * 3600 + m2 * 60 + s2

    var a = 0
    var b = 0
    var c = 0

    if (t1 % 3600 == 0) {
        a += 1
        if (t1 % 43200 == 0) {
            b += 1
        }
        t1 += 1
    }

    for (i in t1..t2) {
        if ((i % 60 == i / 60 % 60 + 1 && i % 3600 != 1) || i % 3600 == 0) {
            a += 1
            println("a ${i/3600} ${i/60%60} ${i%60}")
        }
        if (i % 43200 == 0 || (i != 43201 && (i / 720 + 1) % 60 == i % 60)) {
            b += 1
            println("b ${i/3600} ${i/60%60} ${i%60}")
        }
        if (i % 43200 == 0) {
            c += 1
            println("c ${i/3600} ${i/60%60} ${i%60}")
        }
    }

    println("$a $b $c ${a+b-c}")
}