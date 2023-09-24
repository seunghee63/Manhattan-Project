// 2ms, 2.84mb
package main

import "fmt"

func main() {
	fmt.Println(generateParenthesis(1))
}

func generateParenthesis(n int) []string {

	var result []string

	var createParenthesisRecursively func(temp string, n, leftBracketCount, rightBracketCount int)
	createParenthesisRecursively = func(temp string, n, leftBracketCount, rightBracketCount int) {
		if len(temp) == n*2 {
			result = append(result, temp)
			return
		}

		if leftBracketCount < n {
			createParenthesisRecursively(temp+"(", n, leftBracketCount+1, rightBracketCount)
		}

		if rightBracketCount < leftBracketCount {
			createParenthesisRecursively(temp+")", n, leftBracketCount, rightBracketCount+1)
		}
	}

	createParenthesisRecursively("", n, 0, 0)
	return result
}
