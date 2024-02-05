class Solution {
    // 199 ms (56.07%), 37.67MB (64.49%)
    fun subsets(nums: IntArray): List<List<Int>> {
        return powerSet(nums, 0, listOf())
    }

    fun powerSet(nums: IntArray, level: Int, result: List<Int>): List<List<Int>> {
        if(level == nums.size) {
            return listOf(result)
        }

        val left = powerSet(nums,level + 1, result)
        val right = powerSet(nums,level + 1, result + nums[level])
        println(left + right)
        return left + right
    }
}
