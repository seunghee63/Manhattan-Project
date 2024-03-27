class Solution {
	// 211 ms(51.52%), 38.36 MB(12.12%)

	// head - 4 -> 2 -> 1 -> 3
    // spare ->4
    // spare ->2->4
    // spare ->1->2->4
    // spare ->1->2->3->4
    fun insertionSortList(head: ListNode?): ListNode? {
        val spare = ListNode(-1)
        var cur = head

        while (cur != null) {
            var prev: ListNode? = spare

            while (prev?.next != null && cur.`val` > prev.next!!.`val`) {
                prev = prev.next
            }

            val temp: ListNode? = cur.next
            cur.next = prev?.next
            prev?.next = cur
            cur = temp
        }
        return spare.next
    }
}
