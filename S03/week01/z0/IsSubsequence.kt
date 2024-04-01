class Solution {
    // 164ms(6.45%)
    // 35.07MB(18.43%)
    fun isSubsequence(s: String, t: String): Boolean {
        var tHead = 0
        var sHead = 0

        while (tHead <= t.lastIndex && sHead <= s.lastIndex) {
            if (s[sHead] == t[tHead]) {
                sHead++
            }
            tHead++
        }


        return sHead == s.length
    }

    // 134ms(61.60%)
    // 35.14MB(16.44%)
    fun isSubsequence(s: String, t: String): Boolean {
        if(s.length == 0) return true
        if(s.length > t.length) return false
        if(s.length == 1) return t.contains(s)
    
        var tHead = 0
        var tTail = t.lastIndex
        var sHead = 0
        var sTail = s.lastIndex

        while (tHead < tTail && sHead <= sTail) {
            if (s[sHead] == t[tHead]) {
                sHead++
            }
            if (s[sTail] == t[tTail]) {
                sTail--
            }
            tHead++
            tTail--
        }


        return sHead > sTail
    }
}
