class Solution {
    fun countDistinct(nums: IntArray, k: Int, p: Int): Int {
        val result = mutableSetOf<List<Int>>()
        
        for(i in 0 .. nums.lastIndex){
            for(j in 0 until nums.lastIndex - i + 1){
                val subArr = nums.slice(j .. j + i )
                if(subArr.filter { it % p == 0 }.size <= k){
                    result.add(subArr)
                }
            }
        }
        return result.size
    }
}
