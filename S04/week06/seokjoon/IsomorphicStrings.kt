//196mb, 37mb

class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {

        // s의 각 문자열과 그에 대응하는 t의 문자열 저장
        val sMap = mutableMapOf<Char, Char>() 
        // t의 각 문자열과 그에 대응하는 s의 문자열 저장
        val tMap = mutableMapOf<Char, Char>()

        for (i in s.indices) {
            val sChar = s[i]
            val tChar = t[i]

            // sMap에 sChar에 해당하는 문자값이 있는지 체크
            if (sMap.containsKey(sChar)) { // 있을 때 
                if (sMap[sChar] != tChar) { // 이미 저장된 문자값과 실제로 대응되어야 할 값이 다르면 false 를 리턴한다.
                    return false
                }
            } else { 
                sMap[sChar] = tChar // 없을 때는 대응되는 문자값을 저장한다.
            }

            // 위와 동일한 로직을 tMap에 적용하여 구한다.
            if (tMap.containsKey(tChar)) {
                if (tMap[tChar] != sChar) {
                    return false
                }
            } else {
                tMap[tChar] = sChar
            }
        }

        return true
    }
}
