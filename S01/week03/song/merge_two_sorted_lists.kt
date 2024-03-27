// Runtime : 153ms, Memory : 35.46MB
class Solution21 {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var result = ListNode(0)
        val head = result
        var l1 = list1
        var l2 = list2

        while(l1 != null && l2 != null){
            if (l1.`val` < l2.`val`){
                result.next = l1
                l1 = l1.next
            }else{
                result.next = l2
                l2 = l2.next
            }
            result = result.next!!
        }

        if (l1 == null)
            result.next = l2

        if (l2 == null)
            result.next = l1

        return head.next
    }
}