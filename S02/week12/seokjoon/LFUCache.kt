//889ms, 143.5mb

class LFUCache(val capacity: Int) {
    //key, value 저장하는 Map
    val valueMap : MutableMap<Int,Int> = mutableMapOf()
    //key와 key 사용횟수를 저장하는 Map
    val cntMap : MutableMap<Int, Int> = mutableMapOf()
    //key 사용횟수 별로 LinkedHashSet을 저장하는 Map
    //LinkedHashSet 는 동일한 사용횟수일 때 LRU를 뽑아내기 위함.
    val linkedHashSetMap : MutableMap<Int,LinkedHashSet<Int>> = mutableMapOf()
    
    var minCnt = Int.MAX_VALUE

    fun get(key: Int): Int {
        return if(cntMap.containsKey(key)){
            sortMaps(key)
            valueMap[key] ?: -1
        }else {
            -1
        }
    }

    fun put(key: Int, value: Int) {
        if(cntMap.containsKey(key)){
            valueMap[key] = value
            sortMaps(key)
        }else {
            if(cntMap.size == capacity){
                linkedHashSetMap.getValue(minCnt).first().let{ target ->
                    linkedHashSetMap.getValue(minCnt).remove(target)
                    valueMap.remove(target)
                    cntMap.remove(target)
                }
            }
            cntMap[key] = 1
            addLinkedHashSetMap(1,key)
            valueMap[key] = value
            minCnt = 1
        }
    }

    fun addLinkedHashSetMap(count : Int,key : Int){
        if(linkedHashSetMap.containsKey(count)){
            linkedHashSetMap[count]?.add(key)
        }else {
            linkedHashSetMap[count] = LinkedHashSet<Int>().apply { 
                this.add(key)
            }
        }
    }

    fun refreshMaps(key : Int){
        linkedHashSetMap[cntMap.getValue(key)]?.remove(key)
        //새 사용횟수로 갱신
        cntMap[key] = cntMap.getValue(key) + 1

        addLinkedHashSetMap(cntMap.getValue(key), key)
        if(linkedHashSetMap[minCnt]?.isEmpty() == true){
            linkedHashSetMap.remove(minCnt)
            minCnt = cntMap.getValue(key)
        }else minCnt = minOf(cntMap.getValue(key), minCnt)
    }
    
}

