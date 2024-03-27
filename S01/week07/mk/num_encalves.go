// 49ms, 10.8mb
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

	for row := range grid {
		for column := range grid[row] {
			if row == 0 || column == 0 || row == rowCount-1 || column == columnCount-1 {
				dfs(&grid, row, column)
			}
		}
	}

	result := 0
	for row := range grid {
		for column := range grid[row] {
			result += grid[row][column]
		}
	}

	return result
}

func dfs(grid *[][]int, row, column int) {
	if row < 0 || column < 0 || row == rowCount || column == columnCount || (*grid)[row][column] == 0 {
		return
	}

	(*grid)[row][column] = 0

	dfs(grid, row-1, column)
	dfs(grid, row, column-1)
	dfs(grid, row+1, column)
	dfs(grid, row, column+1)
}
