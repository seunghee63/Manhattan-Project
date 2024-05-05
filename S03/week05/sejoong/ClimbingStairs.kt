class Solution {
    fun climbStairs(n: Int): Int {
        return climb(n, 2) + climb(n, 1)
    }

    private fun climb(stairCount: Int, stepCount: Int) : Int {
        val remainedStairCount = stairCount - stepCount
        if (remainedStairCount < 0) return 0
        if (remainedStairCount == 0 || remainedStairCount == 1) return 1

        return climb(remainedStairCount, 2) + climb(remainedStairCount, 1)
    }
}
