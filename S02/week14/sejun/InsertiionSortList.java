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
// 233ms, 45.34mb ->
class Solution {
    public ListNode insertionSortList(ListNode head) {
        int size = size(head);
        ListNode cur = head;
        for (int i = 0; i < size; i++) {
            cur = sort(cur, i, 0);
        }

        return cur;
    }

    public ListNode sort(ListNode node, Integer loopCount, Integer count) {
        if (Objects.equals(loopCount, count)) {
            return node;
        }

        ListNode next = sort(node.next, loopCount, count + 1);
        node.next = next;
        if (node.val > next.val) {
            swap(node, next);
            return next;
        }

        return node;
    }

    public void swap(ListNode node, ListNode next) {
        ListNode temp = next.next;
        next.next = node;
        node.next = temp;
    }

    public int size(ListNode head) {
        int nodeSize = 1;
        ListNode cur = head;
        while(cur.next != null) {
            nodeSize++;
            cur = cur.next;
        }

        return nodeSize;
    }
}

// 277ms, 49.68mb <-
class Solution {
    public ListNode insertionSortList(ListNode head) {
        int size = size(head);
        ListNode cur = head;
        for (int i = 0; i < size; i++) {
            cur = injectionSort(cur);
        }

        return cur;
    }

    public ListNode injectionSort(ListNode node) {
        if (node.next == null) {
            return node;
        }

        ListNode next = injectionSort(node.next);
        node.next = next;
        if (node.val > next.val) {
            swap(node, next);
            return next;
        }

        return node;
    }

    public void swap(ListNode node, ListNode next) {
        ListNode temp = next.next;
        next.next = node;
        node.next = temp;
    }

    public int size(ListNode head) {
        int nodeSize = 1;
        ListNode cur = head;
        while(cur.next != null) {
            nodeSize++;
            cur = cur.next;
        }

        return nodeSize;
    }
}
