// Runtime : 0ms / Memory : 2.10 MB
package main

import "fmt"

func main() {
	result := strStr("sadbutsad", "sad")
	fmt.Println(result)
}

func strStr(haystack string, needle string) int {
	var temp = ""
	for i := 0; i < len(haystack); i++ {
		char := string(haystack[i])
		temp += char
		if temp == needle {
			return i - (len(needle) - 1)
		}

		if len(temp) == len(needle) {
			temp = temp[1:]
		}
	}

	return -1
}
