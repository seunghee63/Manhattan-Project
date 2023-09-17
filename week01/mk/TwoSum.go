// Runtime : 7ms / Memory : 4.3 MB

package main

import "fmt"

func main() {
	result := twoSum([]int{-3, 0, 3, 6}, 0)
	fmt.Println(result)
}

func twoSum(nums []int, target int) []int {
	numMap := make(map[int]int)
	for index, value := range nums {
		firstNum := target - value
		firstNumIndex, exist := numMap[firstNum]
		if exist {
			secondNumIndex := index
			return []int{firstNumIndex, secondNumIndex}
		}
		numMap[value] = index
	}

	return []int{}
}
