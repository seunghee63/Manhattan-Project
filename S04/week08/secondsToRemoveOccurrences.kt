class Solution {
    private var stepCount = 0

    fun secondsToRemoveOccurrences(s: String): Int {
        stepCount++
        val updatedString = StringBuilder()
        var isSorted = true

        var i = 0
        while (i < s.length) {
            // "01"을 발견하면 뒤집어서 "10"으로 바꿈
            if (i < s.length - 1 && s[i] == '0' && s[i + 1] == '1') {
                isSorted = false
                updatedString.append('1').append('0')
                i += 2
            } else {
                // "01"이 아니면 그대로 추가
                updatedString.append(s[i])
                i++
            }
        }

        // 더 이상 "01"이 없으면 stepCount 반환, 아니면 재귀 호출
        return if (isSorted) stepCount - 1 else secondsToRemoveOccurrences(updatedString.toString())
    }
}
