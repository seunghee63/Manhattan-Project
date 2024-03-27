class Solution2 {
    // 471 ms, 45.1 MB
    private var temp = mutableMapOf<Int, Int>()
    fun coinChange(coins: IntArray, amount: Int): Int {
        if(amount == 0) return 0

        change(coins, amount)
        val min = temp[amount]
        return if(min == Int.MAX_VALUE) -1 else min!!
    }

    private fun change(coins: IntArray, rest: Int): Int {
        if(rest == 0) return 0
        if(rest < 0) return Int.MAX_VALUE
        temp[rest]?.let { return it }

        temp[rest] = Int.MAX_VALUE
        coins.forEach {
            val count = change(coins, rest - it)
            if(temp[rest]!! > count) temp[rest] = count + 1
        }
        return temp[rest]!!
    }
}
