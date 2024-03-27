class Solution {
	// 221ms, 43.76MB
	fun majorityElement(nums: IntArray): Int {
		val n = nums.size
		nums.sort()
		return nums[n/2]
	}
}
