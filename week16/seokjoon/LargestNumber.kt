//233ms, 40.02mb

class Solution {
    fun largestNumber(nums: IntArray): String {
        val result = nums.sortedWith { o1, o2 ->
            compareString("$o1$o2","$o2$o1")
        }.joinToString("")

        var startIndex = -1
        for(i in 0 until result.length - 1){
            if(result[i] == '0') startIndex = i
            else break;
        }
        return result.substring(startIndex+1)
    }

    private fun compareString(s1 : String, s2 : String) : Int {
        if(s1.length != s2.length){
            return  s2.length - s1.length
        }else {
            for(i in 0 until s1.length){
                if(s1[i] != s2[i]){
                    return s2[i] - s1[i]
                }
            }
        }
        return 0
    }
}
