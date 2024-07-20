class Solution {
    // Runtime : 1147ms (21.31%)
    // Memory : 84.73MB (36.07%)
    // Timer : 00:32:58
    fun modifiedList(nums: IntArray, head: ListNode?): ListNode? {
        val sets = nums.toMutableSet()
        val result = ListNode(0).apply { next = head }
        var prev = result
        var cur = head
        while(cur != null) {
            if(sets.contains(cur.`val`)) {
                prev.next = cur.next
            } else {
                prev = cur
            }
            cur = cur.next
        }

        return result.next
    }
}
