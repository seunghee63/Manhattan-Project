class Solution {
    // 269ms(39.10%)
    // 47.57MB(7.82%)
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val xArray = hashSetOf<Int>()
        val yArray = hashSetOf<Int>()
        matrix.forEachIndexed { i, row ->
            row.forEachIndexed { j, element ->
                if(element == 0) {
                    xArray.add(i)
                    yArray.add(j)
                }
            }
        }
        for(i in matrix.indices) {
            yArray.forEach { j ->
                matrix[i][j] = 0
            }
        }
        for(j in matrix[0].indices) {
            xArray.forEach { i ->
                matrix[i][j] = 0
            }
        }
    }
}
