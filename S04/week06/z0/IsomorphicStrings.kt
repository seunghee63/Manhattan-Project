class Solution {
    // Runtime: 211ms (28.15%)
    // Memory: 36.97MB (70.80%)
    // Time taken: 24 m 38 s
    fun isIsomorphic(s: String, t: String): Boolean {
        val map = mutableMapOf<Char, Char>() // 문자의 매핑 관계를 저장할 map
        val set = mutableSetOf<Char>() // 이미 매핑된 문자를 기록할 집합
        
        s.forEachIndexed { index, c ->
            // 현재 문자가 이미 매핑되어 있는지 확인
            if (map.containsKey(c)) {
                // 만약 현재 문자가 매핑된 문자와 다르면 false
                if (map[c] != t[index]) return false
            } else {
                // 만약 현재 문자가 처음 나오는 문자일 경우
                // `t` 문자열의 해당 인덱스 문자가 이미 매핑된 문자 중에 있을 경우 false
                if (set.contains(t[index])) return false
                // 현재 문자를 `t`의 해당 문자로 매핑하고, set에 추가
                map[c] = t[index]
                set.add(t[index])
            }
        }
        // 모든 문자에 대해 매핑 검사를 통과한다면 true
        return true
    }

}
