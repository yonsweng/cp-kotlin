fun getPi(s: String): IntArray {
    val pi = IntArray(s.length)
    var j = 0
    for (i in 1 until s.length) {
        while (j > 0 && s[i] != s[j]) {
            j = pi[j - 1]
        }
        if (s[i] == s[j]) {
            pi[i] = ++j
        }
    }
    return pi
}

fun getSuffixArray(s: String): MutableList<Int> {
    val n = s.length
    val sa = MutableList(n) { i -> i }
    var g = IntArray(n + 1)
    var t = 1

    for (i in 0 until n) {
        g[i] = s[i] - 'A'
    }

    while (t <= n) {
        g[n] = -1
        sa.sortWith(Comparator { a, b ->
            if (g[a] != g[b]) g[a] - g[b]
            else g[a + t] - g[b + t]
        })

        val ng = IntArray(n + 1)
        ng[n] = -1
        ng[sa[0]] = 0
        for (i in 1 until n) {
            if (g[sa[i - 1]] != g[sa[i]] || g[sa[i - 1] + t] != g[sa[i] + t]) {
                ng[sa[i]] = ng[sa[i - 1]] + 1
            } else {
                ng[sa[i]] = ng[sa[i - 1]]
            }
        }
        g = ng
        t *= 2
    }

    return sa
}

fun getRank(s: String, sa: MutableList<Int>): IntArray {
    val n = s.length
    val rank = IntArray(n)
    for (i in 0 until n) {
        rank[sa[i]] = i
    }
    return rank
}

fun getLCP(s: String, sa: MutableList<Int>, rank: IntArray): IntArray {
    val n = s.length
    val lcp = IntArray(n)

    var h = 0
    for (i in 0 until n) {
        if (rank[i] > 0) {
            val j = sa[rank[i] - 1]
            while (i + h < n && j + h < n && s[i + h] == s[j + h]) {
                h++
            }
            lcp[rank[i]] = h
        }
        if (h > 0) {
            h--
        }
    }
    return lcp
}

fun main() {
    val s = readln()
    val pi = getPi(s)
    val sa = getSuffixArray(s)
//    sa.forEach { print("$it ") }
//    println()

    val rank = getRank(s, sa)
    val lcp = getLCP(s, sa, rank)
//    lcp.forEach { print("$it ") }

    val answer = mutableListOf<Pair<Int, Int>>()
    val dp = IntArray(s.length)
    // init dp as -1
    for (i in s.indices) {
        dp[i] = -1
    }
    for (i in s.length - 1 downTo 0) {
        var sum = 1
        var j = i + 1
        while (j < s.length) {
            if (lcp[j] >= s.length - sa[i]) {
                sum += dp[j]
                j += dp[j] - 1
            }
            else {
                break
            }
            j += 1
        }
        dp[i] = sum
    }

    // print dp
//    println()
//    dp.forEach { print("$it ") }

    var i = s.length - 1
    while (i > 0) {
        if (pi[i] == 0) break
        answer.add(Pair(pi[i], dp[rank[s.length - pi[i]]]))
        i = pi[i] - 1
    }
    answer.add(Pair(s.length, 1))
    answer.sortWith(Comparator { a, b ->
        a.first - b.first
    })

//    println()
    println(answer.size)
    answer.forEach { println("${it.first} ${it.second}") }
}