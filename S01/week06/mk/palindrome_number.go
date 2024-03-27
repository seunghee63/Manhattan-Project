// 12ms, 6.82mb
package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(isPalindrome(1234))
}

func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}

	if 0 <= x && x < 10 {
		return true
	}

	var intArr []int

	quotient := x
	remainder := 0
	count := -1
	for quotient > 0 {
		remainder = quotient % 10
		quotient = quotient / 10
		count++
		intArr = append(intArr, remainder)
	}

	reverse := 0
	for _, num := range intArr {
		reverse += num * int(math.Pow10(count))
		count--
	}

	return x == reverse
}

/*
func isPalindrome(x int) bool {
	intString := strconv.Itoa(x)
	n := len(intString)
	for i := 0; i < len(intString)/2; i++ {
		if rune(intString[i]) != rune(intString[n-1-i]) {
			return false
		}
	}
	return true
}


*/
