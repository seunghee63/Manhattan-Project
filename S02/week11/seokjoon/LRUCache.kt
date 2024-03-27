import java.util.*

//919ms, 151.3mb
class LRUCache(val capacity: Int) {
    private val map = LinkedHashMap<Int,Int>()

    fun get(key: Int): Int {
        return map.get(key).let {
            if(it == null) -1
            else {
                map.remove(key)
                map[key] = it
                it
            }
        }
    }

    fun put(key: Int, value: Int) {
        if(map.contains(key)) map.remove(key)
        else if(map.size == capacity) map.remove(map.keys.first())  
        map[key] = value
    }
}

// 3674ms, 145.4mb
// 시간이 너무 오래 걸린 것 같아서 위 풀이로 다시 풀었습니다.
class LRUCache(val capacity: Int) {
    private val map = mutableMapOf<Int,Int>()
    private val firstQueue : Queue<Int> = LinkedList()
    private val secondQueue : Queue<Int> = LinkedList()
    private var mainQueueNumber = 1 

    fun get(key: Int): Int {
        return if(map.containsKey(key)){
            refreshQueue(key)
            map.getOrElse(key) { -1 }
        }else -1
    }

    fun put(key: Int, value: Int) {
        if(map.size == capacity){
            if(map.containsKey(key)){
                map[key] = value
                refreshQueue(key)
            }else{
                map.remove(getMainQueue().poll())
                map[key] = value
                getMainQueue().add(key)
            }
        }else {
            map[key] = value
            getMainQueue().add(key)
            if(map.containsKey(key)) refreshQueue(key)
        }
    }

    fun getMainQueue() : Queue<Int> {
        return if(mainQueueNumber == 1) firstQueue else secondQueue
    }

    fun refreshQueue(putKey : Int){
        if(mainQueueNumber == 1){
            moveQueueDataToOtherQueue(firstQueue,secondQueue,putKey)
            mainQueueNumber = 2
        }else {
            moveQueueDataToOtherQueue(secondQueue,firstQueue,putKey)
            mainQueueNumber = 1
        }
    }

    fun moveQueueDataToOtherQueue(mainQueue : Queue<Int>,secondaryQueue : Queue<Int>,putKey : Int){
        while(mainQueue.isNotEmpty()){
            mainQueue.poll().let{ 
                if(it != putKey) secondaryQueue.add(it)
            }
        }
        secondaryQueue.add(putKey)
    }
}
