// 991ms , 76.9mb

class Solution {
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val set = nums.toSet()
        
        val preHead = ListNode().apply {
            next = head
        }
        var curNode = preHead.next
        var preNode = preHead
        while(curNode != null){
            if(set.contains(curNode.`val`)){
                preNode.next = curNode.next
                curNode = preNode.next
            }
            else{
                preNode = curNode
                curNode = curNode.next
            }

        }
        return preHead.next
    }
}
