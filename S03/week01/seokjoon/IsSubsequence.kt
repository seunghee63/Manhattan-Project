//111ms, 33.91mb
class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if(s == t || s == "") return true
        if(t == "") return false

        var sIndex = 0;
        for(c in t){
            if(s[sIndex] == c) sIndex++;
            if(sIndex == s.length) return true
        }

        return false
    }
}
