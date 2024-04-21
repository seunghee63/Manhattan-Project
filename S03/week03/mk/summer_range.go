// 2ms
package main

import (
	"fmt"
	"strconv"
)

func main() {
	fmt.Println(summaryRanges([]int{0, 1, 2, 4, 5, 7}))
}

func summaryRanges(nums []int) []string {
	if len(nums) == 0 {
		return []string{}
	}
	var res []string

	count := 0
	for i := 0; i < len(nums); i++ {
		if i != 0 && nums[i]-1 > nums[i-1] {
			res = addToRes(nums, i, count, res)
			count = 0
		}
		count++
	}
	return addToRes(nums, len(nums), count, res)
}

func addToRes(nums []int, i, count int, res []string) []string {
	s := strconv.Itoa(nums[i-count])
	if count > 1 {
		s += "->"
		s += strconv.Itoa(nums[i-1])
	}
	res = append(res, s)
	return res
}
