// 2ms, 2.3mb
package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(longestCommonPrefix([]string{"flower", "flow", "flight"}))

}

func longestCommonPrefix(s []string) string {
	result := s[0]
	for i := 1; i < len(s); i++ {
		for !strings.HasPrefix(s[i], result) {
			result = result[:len(result)-1]
		}
	}
	return result
}

/*
func longestCommonPrefix(strs []string) string {
	result := strs[0]
	for i := 1; i < len(strs); i++ {
		current := strs[i]
		compareLen := 0
		if len(result) < len(current) {
			compareLen = len(result)
		} else {
			compareLen = len(current)
		}

		sameIndex := 0
		for j := 0; j < compareLen; j++ {
			if result[j] == current[j] {
				sameIndex++
			} else {
				break
			}
		}
		result = result[:sameIndex]
	}

	return result
}
*/
