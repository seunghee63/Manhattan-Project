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

// list1 1, 5, 9
// list2 4 12
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
