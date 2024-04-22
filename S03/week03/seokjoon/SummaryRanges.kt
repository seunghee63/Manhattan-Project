//161ms, 38.04mb

class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        if(nums.isEmpty()) return emptyList()
        else if(nums.size == 1) return listOf("${nums[0]}")
        
        val result = mutableListOf<String>()
        var curIdx = 1
        var startIdx = 0

        while(curIdx <= nums.lastIndex){
            if(nums[curIdx] - nums[curIdx - 1] != 1){
                addStrInResult(startIdx,curIdx,nums,result)
                startIdx = curIdx
            }
            curIdx += 1
        }
        addStrInResult(startIdx,curIdx,nums,result)
        return result
    }

    private fun addStrInResult(startIdx : Int, curIdx : Int, nums: IntArray, result : MutableList<String>){
        if(nums[startIdx] == nums[curIdx - 1]){
            result.add("${nums[startIdx]}")
        }else {
            result.add("${nums[startIdx]}->${nums[curIdx - 1]}")
        }
    }
}
