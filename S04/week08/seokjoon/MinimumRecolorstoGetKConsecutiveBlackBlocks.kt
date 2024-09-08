class Solution {
    fun minimumRecolors(blocks: String, k: Int): Int {
        var answer = k  

        //for 문을 돌면서 모든 경우를 탐색한다. 
        for (i in 0..blocks.length - k) {
            var current = 0
            //i 부터 길이 k만큼 구간에서 W의 개수를 구한다.
            for (j in i until i + k) {
                if (blocks[j] == 'W') {
                    current++
                }
            }
            // 최소값 갱신
            answer = minOf(answer, current)
        }
        
        return answer
    }
}
