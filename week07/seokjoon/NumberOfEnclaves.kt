// https://leetcode.com/problems/number-of-enclaves
// 353ms, 54.40mb

import java.util.ArrayDeque

class Solution {
    val dx = listOf(1,-1,0,0)
    val dy = listOf(0,0,1,-1)
    fun numEnclaves(grid: Array<IntArray>): Int {
        val visited : Array<BooleanArray> = Array(grid.size){ BooleanArray(grid[0].size){false} }
        var result = 0
        for(i in 0 until grid.size){
            for(j in 0 until grid[i].size){
                if(grid[i][j] == 1 &&! visited[i][j]){
                    result += bfs(i,j,grid,visited)
                }
            }
        }

        return result
    }

    fun bfs(sx : Int, sy : Int, grid : Array<IntArray>,visited: Array<BooleanArray> ) : Int {    
        val queue : Deque<Pair<Int,Int>> = ArrayDeque()
       
        var isEdgeLand = isEdge(sx,sy,grid) // 가장자리에 인접한 섬인지를 판단할 Boolean값
        var sum = 1 // 섬의 크기를 나타내는 Int값
        
        queue.add(Pair(sx,sy))
        visited[sx][sy] = true

        while(queue.isNotEmpty()){
            val (x, y) = queue.poll()
            for(i in 0 .. 3){
                val nx = x + dx[i]
                val ny = y + dy[i]
                if(nx < 0 || ny < 0 || nx > grid.lastIndex || ny > grid[0].lastIndex) continue
                if(grid[nx][ny] == 0 || visited[nx][ny]) continue                
                if(isEdge(nx,ny,grid)) isEdgeLand = true // 섬 일부 중 한 곳이라도 가장자리에 있으면 true로 한다.
                sum++
                queue.add(Pair(nx,ny))
                visited[nx][ny] = true
            }
        }
        return if(isEdgeLand) 0 else sum 
    }

    private fun isEdge(x:Int, y : Int, grid:Array<IntArray>) =  x == 0 || y == 0 || x == grid.lastIndex || y == grid[0].lastIndex
}
