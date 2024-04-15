//286ms , 48.93MB
class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var l = 0
        var r = 0
        var minSize = nums.size + 1
        var curSum = 0
        while(r < nums.size && l <= r){
            curSum += nums[r++] 
            while(curSum >= target && l < r){
                minSize = minOf(minSize, r - l)
                curSum -= nums[l++]
            }
        }
        return if(minSize == nums.size + 1) 0 else minSize
    }
}
