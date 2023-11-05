// https://leetcode.com/problems/climbing-stairs/
// 115ms , 33mb

class Solution {
    fun climbStairs(n: Int): Int {
        if(n == 1 || n == 2) return n

        val arr = IntArray(n+1) { 0 }

        arr[1] = 1
        arr[2] = 2

        for(i in 3 .. n){
            arr[i] = arr[i-1] + arr[i-2]
        }

        return arr[n]
    }
}
