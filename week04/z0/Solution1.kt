class Solution {
    // 218 ms, 37.9 MB
    // 로마숫자는 큰 값부터 시작해서 뒤로 갈수록 작아져야 함
    // i-1가 i보다 큰 경우에는 뺴기를 수행함
    fun romanToInt(s: String): Int {
        val romanDict: Map<Char, Int> = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
        val intList: MutableList<Int> = ArrayList(s.map { romanDict[it] as Int })
        for (i in 1..intList.lastIndex) {
            if(intList[i-1] < intList[i]) {
                intList[i-1] = intList[i-1] * -1
            }
        }
        return intList.sum()
    }
}
