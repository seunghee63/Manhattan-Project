class Solution {
    // Runtime: 180ms(12.50%)
    // Memory: 34.47MB(37.50%)
    fun minimumRecolors(blocks: String, k: Int): Int {
        var result = Int.MAX_VALUE
        for(i in 0..blocks.length-k) {
            val temp = blocks.substring(i, i+k) // k의 길이만큼 substring 자른다
            val count = temp.count { it == 'W' } // 자른 string에서 'W'의 갯수를 센다
            result = min(result, count) // 'W'의 갯수가 가장 적은 값을 찾는다
        }
        return result
    }
}
