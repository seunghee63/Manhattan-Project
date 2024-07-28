class Solution {
    // Runtime : 140ms(88.24%)
    // Memory : 34.74MB(22.06%)
    // Time : 00:10:11
    fun losingPlayer(x: Int, y: Int): String {
        val count = min(x, y / 4)
        return if(count % 2 == 1) "Alice" else "Bob"
    }
}
