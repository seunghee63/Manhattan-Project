// Runtime : 3ms / Memory : 3.12 MB

package main

import (
	"fmt"
	"sort"
)

func main() {
	candidates := []int{7, 3, 2}
	result := combinationSum(candidates, 18)
	fmt.Println(result)
}
func combinationSum(candidates []int, target int) [][]int {
	// candidates 가 정렬되지 않은 채로 재귀 함수 실행시
	// candidates 전체를 탐색해야 해서 비용이 비쌈
	sort.Ints(candidates)
	return findCandidateByRecursively(candidates, []int{}, target, 0, [][]int{})
}

func findCandidateByRecursively(candidates, elements []int, target, index int, result [][]int) [][]int {
	if target == 0 {
		result = append(result, append([]int{}, elements...))
		return result
	}

	if index == len(candidates) {
		return result
	}

	if candidates[index] > target {
		return result
	}

	currentCandidate := candidates[index]
	// 특정 요소 하위 전체 탐색 (밑으로)
	result = findCandidateByRecursively(candidates, append(elements, currentCandidate), target-currentCandidate, index, result)

	// 다음 요소 탐색 (iterator치면 next 호출) (옆으로)
	result = findCandidateByRecursively(candidates, elements, target, index+1, result)

	return result
}
