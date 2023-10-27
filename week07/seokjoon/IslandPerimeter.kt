// https://leetcode.com/problems/island-perimeter/
// 351ms, 52.1mb

import java.util.ArrayDeque
import java.util.Deque

class Solution {
    val dx = listOf(1,-1,0,0)
    val dy = listOf(0,0,1,-1)
        
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var result = 0
        for(i in 0 until grid.size){
            for(j in 0 until grid[i].size){
                if(grid[i][j] == 1){
                    for(k in 0 .. 3){
                        val nx = i + dx[k]
                        val ny = j + dy[k]
                        if(nx < 0 || ny < 0 || nx > grid.lastIndex || ny > grid[0].lastIndex){
                            result++
                            continue
                        }
                        if(grid[nx][ny] == 0) result++
                    }
                }
            }
        }

        return result
    }
}
