// 58ms, 18mb
package main

import (
	"fmt"
)

var rowCount, columnCount int

func main() {
	fmt.Println(numEnclaves([][]int{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}}))
}
func numEnclaves(grid [][]int) int {
	rowCount = len(grid)
	columnCount = len(grid[0])
	visited := make([][]bool, rowCount)
	for i := 0; i < rowCount; i++ {
		visited[i] = make([]bool, columnCount)
	}

	for row := range grid {
		for column := range grid[row] {
			if row == 0 || column == 0 || row == rowCount-1 || column == columnCount-1 {
				dfs(grid, &visited, row, column)
			}
		}
	}

	result := 0
	for row := range grid {
		for column := range grid[row] {
			if grid[row][column] == 1 && !visited[row][column] {
				result++
			}
		}
	}

	return result
}

func dfs(grid [][]int, visited *[][]bool, row, column int) {
	if row < 0 || column < 0 || row == rowCount || column == columnCount || (*visited)[row][column] || grid[row][column] == 0 {
		return
	}

	(*visited)[row][column] = true

	dfs(grid, visited, row-1, column)
	dfs(grid, visited, row, column-1)
	dfs(grid, visited, row+1, column)
	dfs(grid, visited, row, column+1)
}
