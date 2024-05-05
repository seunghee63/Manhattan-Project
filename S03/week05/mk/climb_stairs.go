// 1ms
package main

import "fmt"

func main() {
	fmt.Println(climbStairs(3))
}

func climbStairs(n int) int {
	arr := [46]int{}
	arr[0] = 1
	arr[1] = 1
	if n == 1 {
		return 1
	}
	for i := 2; i <= n; i++ {
		arr[i] = arr[i-1] + arr[i-2]
	}
	return arr[n]
}
