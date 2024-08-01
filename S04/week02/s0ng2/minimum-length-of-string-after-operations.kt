// https://leetcode.com/problems/minimum-length-of-string-after-operations/description/

    fun minimumLength(s: String): Int {
        val n = s.length
        var count = 0
        val hm = HashMap<Char, Int>()
        for (i in 0 until n) {
            if (hm.isEmpty() || !hm.containsKey(s[i])) {
                hm[s[i]] = 1
            } else {
                hm[s[i]] = map[s[i]]!! + 1
                if (hm[s[i]] == 3) {
                    hm[s[i]] = 1
                    count++
                }
            }
        }
        return n - (count * 2)
    }
