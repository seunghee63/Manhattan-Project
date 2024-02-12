// 1ms, 2.37mb
package main

import "fmt"

func main() {
	fmt.Println(subsets([]int{1, 2, 3}))
}

func subsets(nums []int) [][]int {
	subsets := [][]int{{}}
	for _, num := range nums {
		for _, subset := range subsets {
			subsets = append(subsets, append([]int{}, append(subset, num)...))
			fmt.Println(subsets)
		}
	}
	return subsets
}
