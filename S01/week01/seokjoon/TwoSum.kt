// https://leetcode.com/problems/two-sum/
// Runtime : 228ms / Memory : 38 MB

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for(i in 0 until nums.size){
            for(j in i + 1 until nums.size){
                if(nums[i]+nums[j] == target){
                    return intArrayOf(i,j)
                }
            }
        }
        return intArrayOf(0,1)
    }
}