class Solution {
  // 225 ms, 37.6 MB
  // string을 절반 나눠서 양 사이드에서부터 하나씩 비교
    fun isPalindrome(x: Int): Boolean {
        if(x < 0) return false
        
        val string = x.toString()
        val lastIndex = string.lastIndex
        
        for (i in 0 until string.length/2) {
            if(string[i] != string[lastIndex-i]) {
                return false
            }
        }
        return true
    }

    /*
    fun isPalindrome(x: Int): Boolean {
        return x.toString().reversed() == x.toString()
    }
    */
}
