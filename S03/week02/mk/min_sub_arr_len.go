package main

import "fmt"

func main() {
	fmt.Println(minSubArrayLen(7, []int{2, 3, 1, 2, 4, 3}))
}

func minSubArrayLen(target int, nums []int) int {
	out := 0

	start, sum := 0, 0

	for i := 0; i < len(nums); i++ {
		sum += nums[i]

		for sum >= target {
			if out == 0 || (i-start+1) < out {
				out = i - start + 1
			}

			sum -= nums[start]
			start++
		}
	}
	return out
}
