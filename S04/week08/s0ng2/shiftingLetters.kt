class Solution {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val n = s.length
        val shiftSum = IntArray(n + 1) // 누적 합을 저장할 배열

        // 각 shift 명령을 처리하여 shiftSum 배열 업데이트
        for (shift in shifts) {
            val (start, end, direction) = shift
            if (direction == 0) {
                shiftSum[start]--
                shiftSum[end + 1]++
            } else {
                shiftSum[start]++
                shiftSum[end + 1]--
            }
        }

        // 누적 합 계산
        for (i in 1..n) {
            shiftSum[i] += shiftSum[i - 1]
        }

        val result = StringBuilder()

        // 각 문자에 대해 shiftSum만큼 이동 후 새 문자 생성
        for (i in s.indices) {
            val currentChar = s[i]
            val shiftAmount = shiftSum[i]
            val newChar = ((currentChar - 'a' + shiftAmount) % 26 + 26) % 26 + 'a'.toInt()
            result.append(newChar.toChar())
        }

        return result.toString()
    }
}
