// 2ms, 2.3mb
package main

import (
	"fmt"
)

func main() {
	fmt.Println(longestCommonPrefix([]string{"dog", "racecar", "car"}))

}

func longestCommonPrefix(strs []string) string {
	temp := strs[0]
	result := strs[0]
	for i := 1; i < len(strs); i++ {
		current := strs[i]
		compareLen := 0
		if len(temp) < len(current) {
			compareLen = len(temp)
		} else {
			compareLen = len(current)
		}

		sameIndex := 0
		for j := 0; j < compareLen; j++ {
			if temp[j] == current[j] {
				sameIndex++
			} else {
				break
			}
		}
		result = result[:sameIndex]
		temp = result
	}

	return result
}
