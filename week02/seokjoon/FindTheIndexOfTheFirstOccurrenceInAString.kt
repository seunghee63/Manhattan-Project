//https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
//Runtime : 138ms / Memory : 33.5 MB

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        val needleLength = needle.length
        val haystackLength = haystack.length
        if(needleLength > haystackLength) return -1
        else if(needleLength == haystackLength){
            if(needle == haystack) return 0
            else return -1
        }
        else {
            var index = 0
            while(index + needleLength <=haystackLength){
                for(i in 0 until needleLength){
                    if(needle[i] != haystack[i+index]){
                        index += 1
                        break
                    }
                    if(i + 1 == needleLength) return index
                }
            }
            return -1
        }
    }
}
