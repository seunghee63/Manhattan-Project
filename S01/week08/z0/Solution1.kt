class Solution {
    // 134 ms, 33 MB
    // f(n) = f(n-1) + f(n-2)
    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        if (n == 2) return 2

        val f = IntArray(n+1)
        f[1] = 1
        f[2] = 2
        for (i in 3..n) {
            // f(n) = f(n-1) + f(n-2)
            f[i] = f[i-1] + f[i-2]
        }

        return f[n]
    }

    /*
    * fun climbStairs(n: Int): Int {
        // 중단 조건
        if (n == 1) return 1
        if (n == 2) return 2
        if (n == 3) return 3

        // f(n) = f(n-1) + f(n-2)
        return climbStairs(n-1) + climbStairs(n-2)
    }
    * */
}
