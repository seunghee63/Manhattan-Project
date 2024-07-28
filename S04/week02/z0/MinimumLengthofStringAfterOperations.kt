class Solution {
    // Runtime : 352ms(43.75%)
    // Memory : 49.92MB(32.81%)
    // Time : 00:20:22
    fun minimumLength(s: String): Int {
        val counts = IntArray(26)
        for (c in s) {
            counts[c - 'a']++
            if (counts[c - 'a'] >= 3) {
                counts[c - 'a'] = 1
            }
        }
        return counts.sum()
    }
}
