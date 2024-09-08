class Solution {
    // Time Limit Exceeded
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val temp = s.toMutableList()
        shifts.forEach { info ->
            val start = info[0]
            val end = info[1]
            val direction = info[2]
            for(i in start..end) {
                temp[i] = shift(temp[i], direction)
            }
        }
        return temp.joinToString(separator="")
    }

    private fun shift(char: Char, direction: Int): Char {
        return if (direction == 1) {
            if((char+1) > 'z') {
                'a'
            } else {
                char + 1
            }
        } else {
            if ((char - 1) < 'a') {
                'z'
            } else {
                char - 1
            }
        }
    }
}
