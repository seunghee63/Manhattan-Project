class Solution {
    // Runtime: 173ms(7.61%)
    // Memory: 37.12MB(19.87%)
    // Time taken: 1 hr 42 m 17 s
    fun rob(nums: IntArray): Int {
        // M(k) = money at the kth house
        // P(0) = 0
        // P(1) = M(1)
        // P(k) = max(P(k−2) + M(k), P(k−1))
        val sums = IntArray(nums.size) // 각 index까지의 최대 합을 저장하는 어레이
        if (nums.size == 1) return nums[0]
        sums[0] = nums[0]
        sums[1] = max(nums[0], nums[1])
        var i = 2
        while(i <= nums.lastIndex) {
            sums[i] = max(sums[i-2] + nums[i], sums[i-1]) // P(k) = max(P(k−2) + M(k), P(k−1))
            i++
        }
        return sums[nums.lastIndex]
    }
}
