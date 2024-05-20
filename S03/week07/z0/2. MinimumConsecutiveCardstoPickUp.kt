class Solution {
    //596ms(40.00%)
    //53.78MB(60.00%)
    fun minimumCardPickup(cards: IntArray): Int {
        val map = mutableMapOf<Int,Int>()
        var result = Int.MAX_VALUE
        cards.forEachIndexed { i, card ->
            val index = map[card] ?: -1
            if(index >= 0) {
                result = min(i - index + 1, result)
            }
            map[card] = i
        }
        return if(result == Int.MAX_VALUE) -1 else result
    }
}
