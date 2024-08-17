// 192ms , 37.3mb

class Solution {
    fun finalPositionOfSnake(n: Int, commands: List<String>): Int {
        var answer = 0
        // commands 를 순회하면서 UP과 DOWN은 Matrix gird만큼 빼거나 더해주고, RIGHT와 LEFT는 좌우로 움직이기 때문에 1만큼 더해주거나 빼준다.
        commands.forEach { command ->
            when(command){
                "UP" -> {
                    answer -= n
                }
                "RIGHT" -> {
                    answer++
                }
                "DOWN" -> {
                    answer += n
                }
                "LEFT" -> {
                    answer--
                }
            }
        }
        return answer
    }
}
