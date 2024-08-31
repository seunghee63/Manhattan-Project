class Solution {
    // Runtime: 408ms(31.71%)
    // Memory: 45.30MB(21.95%)
    // Time taken: 1 hr 44 m 50 s
    fun countPairs(nums: IntArray): Int {
        var count = 0
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (isAlmostEqual(nums[i], nums[j])) {
                    count++
                }
            }
        }
        return count
    }

    private fun isAlmostEqual(n1: Int, n2: Int): Boolean {
        var x = n1.toString()
        var y = n2.toString()
        // 더 짧은 String 앞에 더 긴 string의 length 만큼 '0'을 추가 
        if (x.length < y.length) {
            x = x.padStart(y.length, '0')
        } else {
            y = y.padStart(x.length, '0')
        }

        val indexes = mutableListOf<Int>()
        for (i in 0..x.lastIndex) {
            if (x[i] != y[i]) { // 같은 index에 있는 char 끼리 비교
                indexes.add(i) // 서로 다르면 indexes 리스트에 저장
            }
            if (indexes.size > 2) { // indexes가 2보다 클 경우 한번의 swap으로는 같은 값을 만들 수 없기 때문에 false 리턴
                return false
            }
        }

        if (indexes.size == 0) { // x와 y가 같다는 의미이므로 true 리턴
            return true
        }
        
        // 서로 다른 index swap 시작
        if (indexes.size == 2) {
            val xCopy = x.toCharArray()
            val temp = xCopy[indexes[0]]
            xCopy[indexes[0]] = xCopy[indexes[1]]
            xCopy[indexes[1]] = temp

            return (xCopy.joinToString(separator="") == y) // swap한 x가 y와 같으면 almost equal
        }
        return false // 그 외 케이스는 모두 false
    }
}
