// runtime : 1ms, memory : 2.06
package main

import "fmt"

func main() {
	fmt.Println(climbStairs(5))
}

// 1 1
// 2 2
// 3 3
// 4 1 1 1 1 / 1 1 2 / 1 2 1 /
// 2 1 1 / 2 2
// 5 1 1 1 1 1 / 1 1 1 2 / 1 1 2 1 / 1 2 1 1 / 1 2 2 /
// 2 1 2 / 2 2 1 / 2 1 1 1 //
func climbStairs(n int) int {
	climbMap := map[int]int{
		1: 1,
		2: 2,
	}

	for i := 3; i <= 45; i++ {
		climbMap[i] = (climbMap[i-1]) + (climbMap[i-2])
	}

	return climbMap[n]
}
