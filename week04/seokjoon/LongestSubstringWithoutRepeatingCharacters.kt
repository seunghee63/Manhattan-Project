// https://leetcode.com/problems/longest-substring-without-repeating-characters
// 178ms, 37.59mb

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        if(s.length == 0) return 0

        var result = 0
        var cnt = 0
        var firstWordIndex = 0
        val map = mutableMapOf<Char,Int>()

        s.forEachIndexed { idx, c->
            if(map.contains(c)){
                for(i in firstWordIndex .. idx - 1){
                    if(s[i] == c){
                        map[c] = idx
                        firstWordIndex = i+1
                        break
                    }else {
                        map.remove(s[i])
                        cnt -= 1
                    }
                }
            }else {
                cnt += 1
                if(cnt == 1){
                    firstWordIndex = idx
                }
                map[c] = idx
            }
            result = max(cnt, result)
        }
        return result
    }
}
