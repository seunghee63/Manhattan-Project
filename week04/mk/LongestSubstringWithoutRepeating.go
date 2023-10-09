// Runtime 4ms / Memory 4.1MB
package main

import "fmt"

func main() {
	fmt.Println(lengthOfLongestSubstring("au"))
}
func lengthOfLongestSubstring(s string) int {
	if len(s) == 1 {
		return 1
	}

	charSet := make(map[string]int)

	result := 0
	startIndex := 0
	endIndex := 0
	substringLen := 0

	for i := 0; i < len(s); i++ {
		current := string(s[i])
		if previousIndex, exist := charSet[current]; exist && previousIndex >= startIndex {
			substringLen = endIndex - startIndex
			if substringLen > result {
				result = substringLen
			}
			startIndex = previousIndex + 1
			endIndex = i
		}

		endIndex++
		charSet[current] = i
	}

	substringLen = endIndex - startIndex
	if substringLen > result {
		result = substringLen
	}

	return result
}
