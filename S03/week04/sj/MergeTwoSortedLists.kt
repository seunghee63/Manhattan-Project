// Runtime 185ms Beats 10.50% of users with Kotlin
// Memory 35.46MB Beats 65.91% of users with Kotlin

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        if (list1 == null || list2 == null) {
            if (list1 != null) return list1
            if (list2 != null) return list2
            return null
        }

        var cursor1 = list1
        var cursor2 = list2
        val mergeHead = ListNode(0)
        var cursorMerge = mergeHead

        while (cursor1 != null && cursor2 != null) {
            if (cursor1.`val` < cursor2.`val`) {
                cursorMerge.next = cursor1
                cursor1 = cursor1.next
            } else {
                cursorMerge.next = cursor2
                cursor2 = cursor2.next
            }
            cursorMerge = cursorMerge.next!!
        }

        cursorMerge.next = cursor1 ?: cursor2

        return mergeHead.next
    }
}
