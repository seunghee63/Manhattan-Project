// https://leetcode.com/problems/longest-common-prefix
// 163ms , 38.2mb

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        val minLength = strs.minOf { it.length }
        var index = 0
    
        for(i in 0 until minLength){
            if(isCommonChar(i,strs)) index += 1
            else break         
        }
        return strs[0].substring(0,index)
    }

    private fun isCommonChar(index : Int, strs: Array<String>) : Boolean {   
        for(str in strs){
            if(strs[0][index] != str[index]) return false
        }
        return true
    }
}
