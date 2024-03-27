class Solution {
  // 192 ms, 38.7 MB
  // 어차피 원하는 결괏값은 정확한 substring이 아닌 max Length만이기 때문에
  // 겹치는 character가 나오면 버림을 한다.
    fun lengthOfLongestSubstring(s: String): Int {
        var temp = ""
        var maxLength = 0
        s.forEach { c ->
            val isContains = temp.contains(c)
            if(isContains) {
                temp = temp.substring(temp.indexOf(c)+1, temp.length)
            }
            temp += c
            if(maxLength < temp.length) {
                maxLength = temp.length
            }

        }
        return maxLength
    }
}
