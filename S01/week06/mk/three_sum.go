// 168ms / 8.07mb
package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(threeSum([]int{-1, 0, 1, 2, -1, -4}))
}

// -4, -1, -1, 0, 1, 2
func threeSum(nums []int) [][]int {
	sort.Ints(nums)
	sumSet := make(map[[3]int]bool)

	for i := 0; i < len(nums); i++ {
		j, k := i+1, len(nums)-1
		for j < k {
			sum := nums[i] + nums[j] + nums[k]
			if sum == 0 {
				sumSet[[3]int{nums[i], nums[j], nums[k]}] = true
			}

			if sum < 0 {
				j++
			} else {
				k--
			}
		}
	}

	var res [][]int
	for triplet := range sumSet {
		res = append(res, []int{triplet[0], triplet[1], triplet[2]})
	}
	return res
}
