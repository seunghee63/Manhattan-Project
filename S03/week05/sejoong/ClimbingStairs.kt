// Runtime 3991ms Beats 5.11% of users with Kotlin
// Memory 32.98MB Beats 65.93% of users with Kotlin
class Solution {
    fun climbStairs(n: Int): Int {
        if (n <=3) return n

        return climb(n, 2) + climb(n, 1)
    }

    private fun climb(stairCount: Int, stepCount: Int) : Int {
        val remainedStairCount = stairCount - stepCount
        if (remainedStairCount <= 3) return remainedStairCount

        return climb(remainedStairCount, 2) + climb(remainedStairCount, 1)
    }
}
