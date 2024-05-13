//178ms, 37.6mb
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex
        var idx = (l + r) / 2

        while(l<=r){
            if(nums[idx] == target){
                return idx
            }else if(nums[idx] < target){
                l = idx + 1
            }else {
                r = idx - 1
            }
            idx = (l + r) / 2
        }
        return if(nums[idx] > target) 0 else idx + 1
    }
}
