//237ms , 40.38mb
class Solution {
    fun majorityElement(nums: IntArray): Int {
        val map = mutableMapOf<Int,Int>()
        val targetCount = nums.size / 2 + 1

        nums.forEach {
            map[it] = map.getOrDefault(it,0) + 1
            if(map.getValue(it) >= targetCount) return it
        }
        // 만약 여기까지 도달한다면.. 
        var result = 0
        map.forEach { key, value ->
            if(value >= targetCount) result = key
        }

        return result
    }
}
