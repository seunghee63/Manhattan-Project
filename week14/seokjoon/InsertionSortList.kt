//200ms, 37.08mb
class Solution {
    fun insertionSortList(head: ListNode?): ListNode? {
        var curNode = head
        val newHeadNode = ListNode(-5001)
        while(curNode != null){
            var curNewNode = newHeadNode
            while(curNewNode.next != null && curNewNode.next!!.`val` < curNode!!.`val` ){  // curNewNode의 `val`이 삽입할 Node의 `val`보다 크거나 null일 때까지 curNewNode 위치를 옮겨준다.
                curNewNode = curNewNode.next
            }
            if(curNewNode.next == null){ //curNewNode.next가 null이면 next에 새로운 Node 추가
                curNewNode.next = ListNode(curNode!!.`val`)
            }else { //curNewNode.next가 null이 아니면 next 사이에 새로운 Node 추가 후 이어붙여준다. 
                curNewNode.next = ListNode(curNode!!.`val`).apply {
                    next = curNewNode.next
                }
            }
            curNode = curNode?.next
        }
        return newHeadNode?.next
    }
}
