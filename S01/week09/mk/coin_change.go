package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(coinChange([]int{1, 2, 5}, 11))
}

func coinChange(coins []int, amount int) int {
	if amount == 0 {
		return 0
	}

	coinCase := make([]int, amount+1)
	for i := range coinCase {
		coinCase[i] = math.MaxInt32
	}
	coinCase[0] = 0

	for currentAmount := 1; currentAmount <= amount; currentAmount++ {
		for _, coin := range coins {
			if currentAmount-coin < 0 {
				continue
			}

			// 12 = 7 (+1) + 12,
			coinCase[currentAmount] = min(coinCase[currentAmount-coin]+1, coinCase[currentAmount])
		}
	}

	if coinCase[amount] == math.MaxInt32 {
		return -1
	}

	return coinCase[amount]

}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
