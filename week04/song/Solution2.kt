class Solution {
    //Runtime 218ms Memory 37.11MB
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var i = 0
        var j = 0
        val set = mutableSetOf<Char>()

        while (j < s.length) {
            if (!set.contains(s[j])) {
                set.add(s[j])
                j++
                max = maxOf(max, set.size)
            } else {
                set.remove(s[i])
                i++
            }
        }

        return max
    }
}
