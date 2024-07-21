//187ms , 37.1mb

class Solution {
    fun getSmallestString(s: String): String {
        for(i in 0 until s.lastIndex){
            if(s[i] > s[i+1] && isSameParityChar(s[i],s[i+1])){
                return s.getSwappedString(i,i+1)
            }
        }
        return s
    }

    private fun isSameParityChar(c1 : Char, c2 : Char) =
        isSameParity(Character.getNumericValue(c1), Character.getNumericValue(c2))
    
    private fun isSameParity(i1 : Int, i2 :Int) =
        (i1 % 2 == 0 && i2 % 2 == 0) || (i1 % 2 != 0 && i2 % 2 != 0)

    private fun String.getSwappedString(i1: Int, i2: Int): String {
        val sb = StringBuilder(this)
        val temp = sb[i1]
        sb.setCharAt(i1, sb[i2])
        sb.setCharAt(i2, temp)

        return sb.toString()
    }

}
