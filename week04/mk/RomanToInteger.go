// Rumtime : 3ms / Memory : 2.8mb
package main

import "fmt"

func main() {
	fmt.Println(romanToInt("MCMXCIV"))
}
func romanToInt(s string) int {
	symbolMap := map[string]int{
		"I": 1,
		"V": 5,
		"X": 10,
		"L": 50,
		"C": 100,
		"D": 500,
		"M": 1000,
	}

	result := 0
	for i := len(s) - 1; i >= 0; i-- {
		currentValue := symbolMap[string(s[i])]
		if i < len(s)-1 && currentValue < symbolMap[string(s[i+1])] {
			result -= currentValue
		} else {
			result += currentValue
		}
	}

	return result
}
