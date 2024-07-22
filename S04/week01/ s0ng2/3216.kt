class Solution {
    fun getSmallestString(s: String): String {
        val arr = s.toCharArray()
        var prev = arr[0]
        for (i in 1 until arr.size) {
            val curr = arr[i]
            if (prev.toInt() % 2 == curr.toInt() % 2 && prev > curr) {
                arr[i] = arr[i - 1]
                arr[i - 1] = curr
                break
            }
            prev = curr
        }
        return String(arr)
    }
}
