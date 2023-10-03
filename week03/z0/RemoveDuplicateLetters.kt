class Solution {
  // 못 품....ㅠ
    fun removeDuplicateLetters(s: String): String {
        var smallest = 'z'
        s.forEach {
            if(it < smallest) {
                smallest = it
            }
        }
        var result = ""
        s.forEachIndexed { i, c ->
            val j = result.indexOf(c)
            if(j >= 0) {
                if(c != smallest) {
                    val temp1 = result.substring(0, j)
                    val temp2 = result.substring(j + 1, result.length)
                    if (temp1.isEmpty() || temp1 >= temp2) {
                        result = result.removeRange(j, j + 1)
                        result += c
                    }
                }
            } else {
                result += c
            }
        }
        return result
    }
}
