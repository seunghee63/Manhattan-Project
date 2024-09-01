class Solution {

    fun countPairs(nums: IntArray): Int {
        var pairCount = 0

        // 모든 쌍 비교
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (areAlmostEqual(nums[i], nums[j])) {
                    pairCount++
                }
            }
        }

        return pairCount
    }

    // 두 숫자가 'almost equal' 인지 확인하는 함수
    private fun areAlmostEqual(num1: Int, num2: Int): Boolean {
        // 두 숫자가 동일하면 바로 true 반환
        if (num1 == num2) return true

        // 두 숫자를 문자열로 변환하고, 길이를 맞추기 위해 짧은 쪽에 '0' 추가
        val str1 = num1.toString().padStart(maxOf(num1.toString().length, num2.toString().length), '0')
        val str2 = num2.toString().padStart(maxOf(num1.toString().length, num2.toString().length), '0')

        // 서로 다른 자릿수
        val mismatchedIndices = mutableListOf<Pair<Int, Int>>()

        // 각 자리 비교
        for (i in str1.indices) {
            if (str1[i] != str2[i]) {
                mismatchedIndices.add(i to i)
                if (mismatchedIndices.size > 2) return false // 차이가 2개를 넘으면 false
            }
        }

        // 차이가 2자리인 경우, 자리를 교환해 확인
        return if (mismatchedIndices.size == 2) {
            val (firstIdx, secondIdx) = mismatchedIndices
            val swappedStr1 = str1.toCharArray().apply {
                this[firstIdx.first] = str1[secondIdx.first]
                this[secondIdx.first] = str1[firstIdx.first]
            }
            swappedStr1.concatToString() == str2
        } else {
            false
        }
    }
}
