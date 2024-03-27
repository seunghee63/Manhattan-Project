//154ms, 33.84mb

class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val pq = PriorityQueue<Int>(reverseOrder()) // Max Heap

        stones.forEach {
            pq.add(it)
        }

        while(pq.size > 1){
            val y = pq.poll()
            val x = pq.poll()
            if(pq.isEmpty() && x == y ) return 0

            if(x != y){
                pq.add(y-x)
            }
        }
        return pq.poll()

    }
}
