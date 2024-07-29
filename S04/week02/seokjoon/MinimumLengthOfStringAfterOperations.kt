//318ms, 49.54mb

class Solution {
    fun minimumLength(s: String): Int {
        val numbers = IntArray('z' - 'a' + 1) 

        s.forEach { c ->
            val index = c - 'a'
            numbers[index] = if(numbers[index] == 3) 2 else numbers[index] + 1
        }

        return numbers.sumOf { if(it == 3) 1 else it }
    }
}
