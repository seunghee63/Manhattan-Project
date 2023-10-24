class Solution {
  // 787 ms, 57.1 MB
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        val result = mutableSetOf<List<Int>>()
        nums.sort() // 오름차순 정렬

        // 0 <= k < lastIndex
        for (k in 0 until nums.lastIndex) {
            // k < i < j
            var i = k + 1
            var j = nums.lastIndex
            while(i < j) {
                val sum = nums[i] + nums[k] + nums[j]
                when {
                    sum == 0 -> {
                        result.add(listOf( nums[k], nums[i], nums[j]))
                        i++
                        j--
                    }
                    sum < 0 -> i++
                    else -> j--
                }
            }
        }
        return result.toList()
    }
}
