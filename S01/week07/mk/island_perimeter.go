// 36ms, 3.94mb
package main

import "fmt"

const (
	water = 0
	land  = 1
)

func main() {
	fmt.Println(islandPerimeter([][]int{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}))
}

func islandPerimeter(grid [][]int) int {
	perimeter := 0
	for row := range grid {
		for column := range grid[row] {
			if grid[row][column] == water {
				continue
			}

			if grid[row][column] == land {
				perimeter += 4
			}

			if row > 0 && grid[row-1][column] == land {
				perimeter -= 1
			}

			if column > 0 && grid[row][column-1] == land {
				perimeter -= 1
			}

			if row < len(grid)-1 && grid[row+1][column] == land {
				perimeter -= 1
			}

			if column < len(grid[row])-1 && grid[row][column+1] == land {
				perimeter -= 1
			}
		}
	}

	return perimeter
}
