// 0 ms Beats 100.00% of users with Java
// 42.34 MB Beats 55.13% of users with
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;

        while (list1 != null && list2 != null) {
            if ((list1.val <= list2.val)) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        
        addAll(cur, list1);
        addAll(cur, list2);

        return head.next;
    }

    public void addAll(ListNode cur, ListNode extras) {
        while (extras != null) {
            cur.next = new ListNode(extras.val);
            extras = extras.next;
            cur = cur.next;
        }
    }
}
