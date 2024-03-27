//https://leetcode.com/problems/group-anagrams
// 390ms , 44.8mb

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map : MutableMap<String,List<Int>> = mutableMapOf()

        strs.forEachIndexed { index, str ->
            str.toCharArray().sorted().joinToString("").let {
                map[it] =  map.getOrElse(it, {listOf<Int>()}) + index
            }
        }

        return map.map {
            it.value.map {
                strs[it]
            }
        }
    }
}
