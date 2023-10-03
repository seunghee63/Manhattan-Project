class Solution {
  // 169 ms, 36.3 MB
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if(list1?.`val` == null && list2?.`val` == null) {
            return null
        }

        val newList = ListNode()
        merge(list1, list2, newList)

        return newList
    }

    fun merge(node1: ListNode?, node2 : ListNode?, new: ListNode?) {
        val l1 = node1?.`val`
        val l2 = node2?.`val`

        if(l1 == null && l2 == null) {
            return
        }

        when {
            l1 == null -> {
                new?.`val` = l2!!
                new?.next = if(node2.next?.`val` == null) {
                    null
                } else {
                    ListNode()
                }
                merge(node1, node2.next, new?.next)
            }
            l2 == null -> {
                new?.`val` = l1!!
                new?.next = if(node1.next?.`val` == null) {
                    null
                } else {
                    ListNode()
                }
                merge(node1.next, node2, new?.next)
            }
            l1 <= l2 -> {
                new?.`val` = l1!!
                new?.next = ListNode()
                merge(node1.next, node2, new?.next)
            }
            else -> {
                new?.`val` = l2!!
                new?.next = ListNode()
                merge(node1, node2.next, new?.next)
            }
        }
    }
}
