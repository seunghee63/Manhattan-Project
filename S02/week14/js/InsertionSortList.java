/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Runtime 18 ms Beats 58.65% of users with Java
// Memory 44.00 MB Beats 65.77% of users with Java
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode sorted = head;
        head = head.next;
        
        sorted.next = null;
        while(head != null) {
            ListNode cur = sorted;
            ListNode prev = null;
            ListNode target = head;
            
            head = head.next;
            while (cur != null) {
                if (cur.val < target.val) {
                    if (cur.next == null) {
                        cur.next = target;
                        target.next = null;
                        break;
                    } else {
                        prev = cur;
                        cur = cur.next;
                    }
                } else {
                    target.next = cur;
                    if (prev == null) {
                        sorted = target;
                    } else {
                        prev.next = target;
                    }

                    break;
                }
            }
        }

        return sorted;
    }
}
