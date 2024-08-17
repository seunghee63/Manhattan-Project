class Solution {
    // https://leetcode.com/problems/snake-in-matrix/description/
    // Runtime : 173ms (96.91%)
    // Memory : 37.36MB (44.33%)
    // Time : 00:11:58
    fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
        var result = 0
        commands.forEach {
            when(it) {
                "RIGHT" -> result++    // 오른쪽으로 한칸 이동
                "LEFT" -> result--     // 왼쪽으로 한칸 이동
                "DOWN" -> result += n  // n 만큼 + 이동
                "UP" -> result -= n    // n 만큼 - 이동
            }
        }
        return result
    }
}
