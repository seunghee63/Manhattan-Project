// 0ms, 2,12mb
package main

import "fmt"

func main() {
	fmt.Println(letterCombinations("23"))
}

var digitMap = map[string][]string{
	"2": {"a", "b", "c"},
	"3": {"d", "e", "f"},
	"4": {"g", "h", "i"},
	"5": {"j", "k", "l"},
	"6": {"m", "n", "o"},
	"7": {"p", "q", "r", "s"},
	"8": {"t", "u", "v"},
	"9": {"w", "x", "y", "z"},
}

func letterCombinations(digits string) []string {
	var result []string
	if len(digits) == 0 {
		return result
	}

	digit := fmt.Sprintf("%c", digits[0])
	if len(digits) == 1 {
		return digitMap[digit]
	}

	for _, letter := range digitMap[digit] {
		for _, nextLetter := range letterCombinations(digits[1:]) {
			result = append(result, letter+nextLetter)
		}
	}

	return result
}
