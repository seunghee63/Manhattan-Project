// 3ms, 2.39mb
package main

import (
	"fmt"
)

func main() {
	fmt.Println(removeDuplicateLetters("cbacdcbc"))
}

func removeDuplicateLetters(s string) string {
	count, charSet := make(map[string]int), make(map[string]bool)
	result := ""

	for i := 0; i < len(s); i++ {
		char := string(s[i])
		count[char]++
	}

	for i := 0; i < len(s); i++ {
		current := string(s[i])
		count[current]--

		if _, exist := charSet[current]; exist {
			continue
		}

		if len(result) > 0 {
			for len(result) > 0 && lastChar(result) > current && count[lastChar(result)] > 0 {
				delete(charSet, lastChar(result))
				result = result[:len(result)-1]
			}
		}

		result += current
		charSet[current] = true
	}

	return result
}

func lastChar(s string) string {
	return string(s[len(s)-1])
}
