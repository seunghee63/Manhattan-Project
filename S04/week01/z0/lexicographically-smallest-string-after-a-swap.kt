class Solution {
    // Runtime : 196ms (27.69%)
    // Memory : 37.81MB (16.92%)

    fun getSmallestString(s: String): String {
        // parity를 찾는다
        // swap 한다
        // 최소값을 찾는다
        var result = s
        for (i in 0 until s.lastIndex) {
            if(result[i].digitToInt().isEven() xor result[i+1].digitToInt().isEven()) {

            } else {
                if(result[i].digitToInt() > result[i+1].digitToInt()) {
                    result = s.swap(i, s[i])
                    return result
                }
            }
        }
        return result
    }

    private fun Int.isEven(): Boolean {
        return this % 2 == 0
    }

    private fun String.swap(index: Int, value: Char): String {
        return toMutableList().apply {
            removeAt(index)
            add(index+1, value)
        }.joinToString(separator = "")
    }
}
