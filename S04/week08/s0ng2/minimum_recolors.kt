class Solution {
    fun minimumRecolors(blocks: String, k: Int): Int {
        val totalBlocks = blocks.length
        val maxStartIndex = totalBlocks - k
        var minOperations = Int.MAX_VALUE

        // 각 가능한 시작 지점에 대해 순회
        for (start in 0..maxStartIndex) {
            var whiteCount = 0
            
            // k개 연속 블록을 검사
            for (i in start until start + k) {
                if (blocks[i] == 'W') {
                    whiteCount++
                }
            }
            
            // 최소 교체 횟수 업데이트
            minOperations = minOf(minOperations, whiteCount)
        }
        
        return minOperations
    }
}
