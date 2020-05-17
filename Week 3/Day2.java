// Time Complexity - O(n)
// Space Complexity - O(1)
// Maintain two pointers fast and slow and keep on adding the even nodes after the slow pointer.


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
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            ListNode tmp = fast.next;
            fast.next = tmp.next;
            tmp.next = slow.next;
            slow.next = tmp;
            slow = slow.next;
            fast = fast.next;
        }
        return head;
    }
}
