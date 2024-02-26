// 235ms, 39.6mb

class Solution {
    fun maximumOddBinaryNumber(s: String): String {
        return s.toCharArray().sortedDescending().subList(1,s.length).joinToString("") + '1'
    }
}
