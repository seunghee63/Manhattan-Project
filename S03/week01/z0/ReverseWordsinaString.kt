class Solution {
    // 225ms(26.68%)
    // 37.55MB(73.60%)
    fun reverseWords(s: String): String {
        return s.split(" ").filter { it != "" }.reversed().joinToString(separator = " ")
    }
}
