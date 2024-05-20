class Solution {
    // 188ms(16.67%)
    // 37.32MB(6.67%)
    fun removeDigit(number: String, digit: Char): String {
        var result = ""
        number.forEachIndexed { i, n ->
            if(n == digit) {
                val next = (number.getOrElse(i+1) { '0' }).digitToInt()
                if(next > n.digitToInt()) {
                    return number.removeRange(i,i+1)
                } else {
                    result = number.removeRange(i,i+1)
                }
            }
        }

        return result
    }
}
