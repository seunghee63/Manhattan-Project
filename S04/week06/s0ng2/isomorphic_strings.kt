class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        // s의 문자들을 t의 문자들에 매핑하기 위한 맵
        val charMap = mutableMapOf<Char, Char>()
        // 이미 매핑된 t의 문자들을 추적하기 위한 맵
        val mappedChars = mutableSetOf<Char>()

        for (i in s.indices) {
            val charS = s[i]
            val charT = t[i]

            // charS가 처음 등장하는 문자인 경우,
            if (charS !in charMap) {
                // charT가 이미 다른 문자에 매핑되어 있다면 이등변 X
                if (charT in mappedChars) return false
                // charS를 charT로 매핑하고, charT를 매핑된 문자로 추가
                charMap[charS] = charT
                mappedChars.add(charT)
            } else {
                // 이미 매핑된 charS가 현재의 charT와 다르다면 이등변 X
                if (charMap[charS] != charT) return false
            }
        }

        // 모든 조건을 통과하면 두 문자열은 이등변
        return true
    }
}
