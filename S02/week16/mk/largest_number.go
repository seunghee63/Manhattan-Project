// 3ms, 2.90mb
package main

import (
	"fmt"
	"sort"
	"strconv"
	"strings"
)

func main() {
	fmt.Println(largestNumber([]int{5, 30, 34, 3, 9}))
}

func largestNumber(nums []int) string {
	stringArr := []string{}
	for _, num := range nums {
		stringArr = append(stringArr, strconv.Itoa(num))
	}
	sort.Slice(stringArr, func(i, j int) bool {
		return stringArr[i]+stringArr[j] > stringArr[j]+stringArr[i]
	})
	result := ""
	for _, s := range stringArr {
		result += s + ""
	}
	if strings.HasPrefix(result, "00") {
		return "0"
	}
	return result
}
