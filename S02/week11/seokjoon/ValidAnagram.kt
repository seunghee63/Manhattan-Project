//https://leetcode.com/problems/valid-anagram
// 168ms , 37.10mb

class Solution {
    fun isAnagram(s: String, t: String) : Boolean {
        val arr = IntArray('z' - 'a' + 1)
        s.forEach {
            arr[it - 'a'] += 1 
        }
        t.forEach {
            arr[it - 'a'] -= 1
        }

        arr.forEach {
            if(it != 0) return false
        }
        return true
    }
}
