class Solution {
    // 131ms(80.44%)
    // 33.63MB(55.92%)

    val set = hashSetOf<Int>()
    fun isHappy(n: Int): Boolean {
        var result = n
        while(result > 2 && !set.contains(result)) {
            result = getSquaresSum(result)
        }
        return result == 1
    }

    private fun getSquaresSum(n: Int): Int {
        set.add(n)
        var sum = 0
        n.toString().forEach {
            val digit = it.digitToInt()
            sum += digit * digit
        }
        return sum
    }
}
