//98ms, 33.2mb
class Solution {
    fun climbStairs(n: Int): Int {
        if(n <= 2) return n
        val arr = IntArray(n+1)
        arr[1] = 1
        arr[2] = 2
        for(i in 3 .. n){
            arr[i] = arr[i-2] + arr[i-1]
        }
        return arr[n]
    }
}
