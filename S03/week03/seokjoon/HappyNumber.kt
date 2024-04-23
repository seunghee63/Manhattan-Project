//153ms , 33.56mb
class Solution {
    fun isHappy(n: Int): Boolean {
        if(n == 1) return true
        var curNum = n
        val numSet = mutableSetOf<Int>()
        
        while(curNum != 1){
            curNum = "$curNum".sumOf{
                it.digitToInt().pow()
            }
            if(numSet.contains(curNum)) return false
            numSet.add(curNum)
        }
        
        return curNum == 1
    }

    fun Int.pow() : Int {
        return this * this
    }
}
