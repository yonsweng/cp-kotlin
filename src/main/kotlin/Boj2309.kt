fun main() {
    val heights = mutableListOf<Int>()
    for (i in 0 until 9) {
        heights.add(readln().toInt())
    }
    val sum = heights.sum()
    for (i in 0 until 9) {
        for (j in i + 1 until 9) {
            if (sum - heights[i] - heights[j] == 100) {
                heights.remove(heights[i])
                heights.remove(heights[j - 1])
                heights.sort()
                for (k in heights) {
                    println(k)
                }
                return
            }
        }
    }
}