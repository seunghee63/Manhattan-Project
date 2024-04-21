// Runtime: 2 ms
package main

import "fmt"

func main() {
	fmt.Println(isHappy(2))
}
func isHappy(n int) bool {
	result := 0

	for n > 0 {
		quotient := n / 10  // 1
		remainder := n % 10 // 9
		result += remainder * remainder
		n = quotient
	}

	if result == 1 {
		return true
	} else if result == 4 {
		return false
	} else {
		return isHappy(result)
	}
}
