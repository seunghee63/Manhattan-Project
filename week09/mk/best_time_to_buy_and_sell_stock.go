package main

import "fmt"

func main() {
	fmt.Println(maxProfit([]int{7, 1, 5, 3, 6, 4}))
}

func maxProfit(prices []int) int {
	bestProfit := 0

	left := 0
	for right := 1; right < len(prices); right++ {
		if prices[left] > prices[right] {
			left = right
		} else {
			bestProfit = max(bestProfit, prices[right]-prices[left])
		}
	}

	return bestProfit
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
