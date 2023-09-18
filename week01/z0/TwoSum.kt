class Solution {
  // Runtime : 222ms
  // Memory : 39.21MB
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = intArrayOf(-1,-1)
        for(i in 0..nums.lastIndex) {
            val remain = target - nums[i]
            for(j in i+1..nums.lastIndex) {
                if(nums[j] == remain) {
                    result[0] = i
                    result[1] = j
                    break
                }
            }
        }
        return result
    }
}
