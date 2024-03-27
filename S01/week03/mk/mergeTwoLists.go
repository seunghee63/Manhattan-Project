// 3ms, 2.50mb
package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	list1 := ListNode{1, &ListNode{2, &ListNode{4, nil}}}
	list2 := ListNode{2, &ListNode{3, &ListNode{4, nil}}}
	fmt.Println(*mergeTwoLists(&list1, &list2))
}

// listA 1, 5, 9
// listB 4 12 17 18
// 각 list의 item들의 오름 차순으로 정렬 되어 있다는 것이 가장 큰 힌트 입니다.
// 2개의 list를 서로 비교 하며 더 작은 것을 결과값에 집어 넣다가 (26~34 line)
// 하나의 list의 item이 먼저 다 소진되면 즉 A쪽 item은 9번 까지 다 소진 되었고 B list는 아직 12, 17, 18이 남은 상태겠죠?
// 이때 남은 B list의 item 들을 그대로 연결 해주기만 하면 됩니다. (37~41 line)
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	res := &ListNode{}
	current := res
	for list1 != nil && list2 != nil {
		if list1.Val <= list2.Val {
			current.Next = list1
			list1 = list1.Next
		} else {
			current.Next = list2
			list2 = list2.Next
		}
		current = current.Next
	}

	if list1 != nil {
		current.Next = list1
	} else if list2 != nil {
		current.Next = list2
	}

	return res.Next
}
