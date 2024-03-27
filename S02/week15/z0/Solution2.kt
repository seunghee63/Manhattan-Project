class Solution {
    //193ms(62.50%), 37.76MB(62.50%)
    fun restoreIpAddresses(s: String): List<String> {
        if (s.length > 12) return emptyList()
        val result = mutableListOf<String>()
        ipAddress(s, 0, mutableListOf(), result)
        return result
    }

    fun ipAddress(s: String, level: Int, temp: MutableList<String>, result: MutableList<String>) {
        if (temp.size >= 4) {
            if (level == s.length) {
                result.add(temp.joinToString(""))
            } else {
                return
            }
        }

        for (i in level+1..level+3) {
            if (i > s.length) return
            val subString = s.substring(level, i)
            if (subString.length > 1 && subString.startsWith("0")) return
            if (subString.toInt() > 255) return
            temp.add(subString)

            ipAddress(s, i, temp, result)
            if (temp.isNotEmpty()) temp.removeLast()
        }
    }
}
