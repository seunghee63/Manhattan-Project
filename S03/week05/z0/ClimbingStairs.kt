class Solution {
    // 123ms(56.97%)
    // 32.91MB(65.49%)
    fun climbStairs(n: Int): Int {
        val array = IntArray(n+1)
        array[0] = 1
        array[1] = 1

        // f(n-2) + f(n-1) = f(n)
        for(i in 2..n) {
            array[i] = array[i-1] + array[i-2]
        }
        return array[n]
    }
}
