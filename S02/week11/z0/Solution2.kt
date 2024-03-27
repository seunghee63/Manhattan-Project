class Week11 {
    // 1824 ms, 152.3 MB
    class LRUCache(capacity: Int) {
        private val queue : Queue<Int> = LinkedList<Int>()
        private val capacity = capacity
        private val map = mutableMapOf<Int, Int>()

        fun get(key: Int): Int {
            return if(map.contains(key)) {
                queue.remove(key)
                queue.add(key)
                map[key]!!
            } else {
                -1
            }
        }

        fun put(key: Int, value: Int) {
            // 만약 이미 같은 key가 존재한다면
            // 기존 값을 제거
            if(map.contains(key)) {
                queue.remove(key)
            } else if(queue.size >= capacity) {
                // 만약 길이가 capacity를 초과한다면
                // 맨 뒤 값을 제거
                map.remove(queue.remove())
            }
            queue.add(key)
            map[key] = value
        }
    }
}
