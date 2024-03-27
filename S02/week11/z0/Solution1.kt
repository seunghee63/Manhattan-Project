class Week11 {
    // 209 ms, 38.2 MB
    fun isAnagram(s: String, t: String): Boolean {
        // 사용된 Char의 갯수를 저장
        val map = mutableMapOf<Char, Int>()
        s.forEach { c ->
            map[c] = (map[c] ?: 0) + 1
        }

        t.forEach { c ->
            if(map[c] == null || map[c] == 0) {
                return false
            } else {
                map[c] = map[c]!!.minus(1)
            }
        }
        map.forEach { (_, i) ->
            if(i > 0) return false
        }
        return true
    }
}
