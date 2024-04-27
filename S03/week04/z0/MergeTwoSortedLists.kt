class Solution {
    // 159ms(66.56%)
    // 36.61MB(8.67%)
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
            val main = ListNode(-1000)
            merge(main, list1, list2)
            return main.next
        }

        private fun merge(main: ListNode, node1: ListNode?, node2: ListNode?) {
            if(node1 == null && node2 == null) {
                return
            }
            node1?.let { n1 ->
                node2?.let { n2->
                    if(n1.`val` < n2.`val`) {
                        main.next = ListNode(n1.`val`)
                        merge(main.next!!, node1.next, node2)
                    } else {
                        main.next = ListNode(n2.`val`)
                        merge(main.next!!, node1, node2.next)
                    }
                } ?: run {
                    main.next = ListNode(node1.`val`)
                    merge(main.next!!, node1.next, node2)
                }
            } ?: run {
                main.next = ListNode(node2!!.`val`)
                merge(main.next!!, node1, node2.next)
            }
        }
}
