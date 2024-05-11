class Solution {
    // 203ms(7.90%)
    // 38.75MB(6.75%)
    fun searchInsert(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.lastIndex
        while (start <= end) {
            val mid = (start+end)/2
            when {
                target == nums[mid] -> return mid
                target < nums[mid] -> end = mid -1
                target > nums[mid] -> start = mid + 1
            }
        }
        return start
    }
}
