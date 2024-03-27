//https://leetcode.com/problems/combination-sum/
// Runtime : 207ms / Memory : 39.6 MB
class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result : MutableList<List<Int>> = mutableListOf()
        repititionCombination(candidates,target,0,0,listOf(), result)
        return result
    }

    fun repititionCombination(
        array : IntArray,
        target : Int,
        sum : Int,
        currentIndex : Int,
        list : List<Int>,
        result : MutableList<List<Int>>
    ) {
        if(sum >= target){
            if(sum == target) result.add(list)
        }else {
            for(i in currentIndex until array.size){
                repititionCombination(array, target,sum+array[i],i,list+array[i],result)
            }
        }
    }
}