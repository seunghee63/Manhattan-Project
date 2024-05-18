class Solution {
    fun removeDigit(number: String, digit: Char): String {
        var result = ""
        for(i in 0 until number.length){
            if(number[i] == digit){
                val target = number.substring(0,i) + number.substring(i+1, number.length)
                result = maxOf(result,target)
            }
        }
        return result
    }
}
