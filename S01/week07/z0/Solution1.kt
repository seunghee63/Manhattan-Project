class Solution {
  // 295 ms, 49.7 MB
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var border = 0
        for(i in grid.indices) {
            for(j in grid[i].indices) {
                if(grid[i][j] == 1) {
                    // top
                    if(i == 0 || grid[i-1][j] == 0) {
                        border++
                    }
                    // bottom
                    if(i == grid.lastIndex || grid[i+1][j] == 0) {
                        border++
                    }
                    // left
                    if(j == 0 || grid[i][j-1] == 0) {
                        border++
                    }
                    // right
                    if(j == grid[i].lastIndex || grid[i][j+1] == 0) {
                        border++
                    }
                }
            }
        }
        return border
    }
}
