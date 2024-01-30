package main

func insertionSortList(head *ListNode) *ListNode {
	temp := new(ListNode)
	for curr := head; curr != nil; {
		prev := temp
		for prev.Next != nil && prev.Next.Val <= curr.Val {
			prev = prev.Next
		}
		n := curr.Next
		curr.Next = prev.Next
		prev.Next = curr
		curr = n
	}

	return temp.Next
}
