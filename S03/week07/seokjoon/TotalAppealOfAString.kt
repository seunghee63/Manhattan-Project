// Time Limit Exceeded
// Virtual Contest 1시간 30분안에 풀지 못했습니다..

class Solution {
    fun appealSum(s: String): Long {
        var result = 0L
        for(i in 0 until s.length){
            for(j in 0 until s.length - i){
               result += s.substring(j, j + i + 1).toSet().size
            }
        }
        return result
    }
}
