class Solution {
    fun romanToInt(s: String): Int {
        val hm = hashMapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
        var sum = 0
        var tmp = 0
        var preValue = 0

        s.forEachIndexed { i, c ->
            val currentValue = hm[c] ?: 0

            if (i > 0 && preValue > currentValue) {
                sum += tmp
                tmp = 0
            } else if (i > 0 && preValue < currentValue) {
                sum -= tmp
                tmp = 0
            }

            tmp += currentValue
            preValue = currentValue
        }

        return sum + tmp
    }
}
