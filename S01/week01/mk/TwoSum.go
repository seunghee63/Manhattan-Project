// Runtime : 7ms / Memory : 4.3 MB

package main

import "fmt"

func main() {
	result := twoSum([]int{-3, 0, 3, 6}, 0)
	fmt.Println(result)
}

// 핵심은 아래와 같습니다.
// twoSum([]int{1, 2, 3, 4}, target : 5)
// A+B = 5 라는 수식이 있을 때 이는 B = 5-A 로 해석될 수 도 있습니다.
// 즉 첫번째 원소 1이 A라고 하면
// B = 5-1
// 즉 우리는 `4라는 원소가 배열에 있는 지 찾으면 되는 것 입니다.`
// 이때 모든 배열을 for문 돌면서 매번 찾으면 O(n)의 비용이 소요 되기 때문에
// map, set 자료구조의 contains operation O(1) 이라는 것을 생각하여
// nums를 map or set으로 변환해주어 (go는 set이 없습니다..) 탐색속도를 빠르게 해주면 됩니다.
func twoSum(nums []int, target int) []int {
	numMap := make(map[int]int)
	for index, value := range nums {
		firstNum := target - value
		firstNumIndex, exist := numMap[firstNum]
		if exist {
			secondNumIndex := index
			return []int{firstNumIndex, secondNumIndex}
		}
		numMap[value] = index
	}

	return []int{}
}
