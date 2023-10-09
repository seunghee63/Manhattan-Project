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
	substringStartIndex := 0
	substringEndIndex := 0
	substringLen := 0

	for i := 0; i < len(s); i++ {
		current := string(s[i])
		if previousIndex, exist := charSet[current]; exist && previousIndex >= substringStartIndex {
			substringLen = substringEndIndex - substringStartIndex
			if substringLen > result {
				result = substringLen
			}
			substringStartIndex = previousIndex + 1
			substringEndIndex = i
		}

		substringEndIndex++
		charSet[current] = i
	}

	substringLen = substringEndIndex - substringStartIndex
	if substringLen > result {
		result = substringLen
	}

	return result
}
