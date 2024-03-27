// 177ms, 37.16mb

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        rec(nums,0,mutableListOf(), result)
        return result.toList()
    }

    fun rec(nums : IntArray, currentIndex : Int,currentArr : List<Int>, result : MutableList<List<Int>>){
        if(currentIndex >= nums.size){
            result.add(currentArr)
        }else {
            rec(nums, currentIndex + 1, currentArr + nums[currentIndex], result)
            rec(nums, currentIndex + 1, currentArr, result)
        }
    }
}
