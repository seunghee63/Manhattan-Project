class Solution {
    // 143ms, 37.84MB
    fun lastStoneWeight(stones: IntArray): Int {
        val queue = PriorityQueue<Int>(Collections.reverseOrder())
        queue.addAll(stones.asList())

        while(queue.size > 1) {
            val stone1 = queue.poll()
            val stone2 = queue.poll()
            val result = stone1 - stone2
            queue.add(result)
        }
        return queue.poll()
    }
    
}
