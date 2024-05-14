//435ms, 55.53mb
class Solution {
    fun maxSubArray(nums: IntArray): Int {
        if(nums.size == 1) return nums[0]
        var idx = 1
        var result = nums[0]
        var curSum = result
        while(idx < nums.size){
            if(curSum + nums[idx] < nums[idx]){
                curSum = nums[idx++]
            }else {
                curSum = nums[idx++] + curSum
            }
            result = maxOf(curSum,result)
        }
        return result
    }
}
