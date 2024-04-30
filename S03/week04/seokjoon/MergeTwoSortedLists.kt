//158ms, 35.68mb
class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var curResultNode : ListNode? = ListNode(-101)
        val result = curResultNode
        var curNode1 = list1
        var curNode2 = list2
        
        while(curNode1 != null || curNode2 != null){
            if(curNode1 != null && curNode2 != null){
                if(curNode1!!.`val` > curNode2!!.`val`){
                    curResultNode?.next = curNode2
                    curNode2 = curNode2!!.next
                }else {
                    curResultNode?.next = curNode1
                    curNode1 = curNode1!!.next
                }
            }else if(curNode1 == null){
                curResultNode?.next = curNode2
                break
            }else {
                curResultNode?.next = curNode1
                break
            }
            curResultNode = curResultNode?.next
        }
        return result?.next
    }
}
