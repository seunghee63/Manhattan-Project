class Solution {
    fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
        val mat = Array(n) { IntArray(n) }
        var cnt = 0
        for (i in 0 until n) {
            for (j in 0 until n) {
                mat[i][j] = cnt++ // n x n 격자 배열을 생성
            }
        }
        
        var x = 0
        var y = 0

      // 뱀의 위치 업데이트
        for (command in commands) {
            when (command) {
                "RIGHT" -> x++
                "LEFT" -> x--
                "DOWN" -> y++
                "UP" -> y--
            }
        }
    
        return mat[y][x]
    }
}
