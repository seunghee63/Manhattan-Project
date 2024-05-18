class Solution {
    fun minimumCardPickup(cards: IntArray): Int {
        val map = mutableMapOf<Int,List<Int>>()
        
        cards.forEachIndexed { index, card ->
            map[card] = if(map.containsKey(card)) (map.get(card)!! + index) else listOf(index)    
        }
        
        var result = cards.size + 1
        
        map.forEach { _, indexList ->
            if(indexList.size >= 2){
                for(i in 1 .. indexList.lastIndex){
                     result = minOf(result, indexList[i] - indexList[i-1] + 1)
                    
                }
            } 
        }
        return if(result == cards.size + 1) -1 else result
    }
}
