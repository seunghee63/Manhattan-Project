class Solution {
    // Time Limit Exceeded
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val allSum = nums.sum()
        if(allSum < target) {
            return 0
        } else if(allSum == target) {
            return nums.size
        }

        var start = 0
        var length = 1

        while (start <= nums.lastIndex) {
            val end = start + length - 1
            val sum = nums.slice(start..end).sum()
            if (sum >= target) {
                return length
            }
            start++
            if(start + length > nums.size) {
                start = 0
                length++
            }
        }

        return 0
    }
}
