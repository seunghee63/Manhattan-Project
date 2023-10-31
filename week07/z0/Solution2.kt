class Solution {
    // 335 ms, 57.7 MB
    // 경계에 있는 땅들을 모두 없애준 후 남은 땅들을 더해준다.
    fun numEnclaves(grid: Array<IntArray>): Int {
        // grid 상하 경계의 땅 조사
        for (i in grid.indices) {
            removeBoundary(i, 0, grid)
            removeBoundary(i, grid[0].lastIndex, grid)
        }
        // grid 좌우 경계의 땅 조사
        for (j in grid[0].indices) {
            removeBoundary(0, j, grid)
            removeBoundary(grid.lastIndex, j, grid)
        }
        return grid.flatMap { it.toList() }.sum() // 남은 1들의 합
    }

    private fun removeBoundary(i: Int, j: Int, grid: Array<IntArray>) {
        // 종료조건
        // i와 j가 grid 범위 밖으로 벗어난 경우
        if(i < 0 || j < 0 || i > grid.lastIndex || j > grid[0].lastIndex) return
        // 해당 셀이 0인 경우
        if(grid[i][j] == 0) return

        if(grid[i][j] == 1) {
            grid[i][j] = 0 // 0으로 변경
            removeBoundary(i-1, j, grid)
            removeBoundary(i+1, j, grid)
            removeBoundary(i, j-1, grid)
            removeBoundary(i, j+1, grid)
        }
    }
}
