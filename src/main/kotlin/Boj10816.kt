fun main() {
    val n = readln().toInt()
    val nList = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    val mList = readln().split(" ").map { it.toInt() }

    val map = mutableMapOf<Int, Int>()
    nList.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    val result = mutableListOf<Int>()
    mList.forEach {
        result.add(map.getOrDefault(it, 0))
    }

    println(result.joinToString(" "))
}