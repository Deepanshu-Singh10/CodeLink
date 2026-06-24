/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode nexdt) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;
        int length = 1;
        while (newHead.next != null) {
            newHead = newHead.next;
            length++;
        }
        int n = k % length;
        if (n == 0)
            return head;
        int newlen = length - n;
        ListNode temp = head;
        for (int i = 0; i < newlen-1; i++) {
            temp = temp.next;
        }
        ListNode oldhead = head;
        head = temp.next;
        temp.next = null;
        newHead.next = oldhead;
        return head;

    }
}