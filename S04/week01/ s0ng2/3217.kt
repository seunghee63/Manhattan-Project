class ListNode(var value: Int, var next: ListNode? = null)

class Solution {
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        // nums 배열을 Set으로 변환
        val set = nums.toSet()
        
        // 더미 노드 생성
        val dummy = ListNode(0, null)
        var curr: ListNode? = dummy
        var current = head
        
        // 링크드 리스트를 순회
        while (current != null) {
            if (current.value !in set) {
                // Set에 없는 값인 경우, 새로운 리스트에 추가
                curr?.next = current
                curr = curr?.next
            }
            // 다음 노드로 이동
            current = current.next
        }
        
        // 마지막 노드의 다음을 null로 설정
        curr?.next = null
        
        // 더미 노드의 다음 노드 반환
        return dummy.next
    }
}
