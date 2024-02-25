// 0ms, 3.89mb
package main

import "fmt"

func main() {
	fmt.Println(maximumOddBinaryNumber("010"))
}

func maximumOddBinaryNumber(s string) string {
	oneCount := 0
	zeroCount := 0
	for i := 0; i < len(s); i++ {
		if s[i] == '1' {
			oneCount++
		} else {
			zeroCount++
		}
	}

	result := ""
	if oneCount == 1 {
		for i := 0; i < zeroCount; i++ {
			result += "0"
		}
		return result + "1"
	}

	for i := 0; i < oneCount-1; i++ {
		result += "1"
	}
	for i := 0; i < zeroCount; i++ {
		result += "0"
	}
	return result + "1"
}
