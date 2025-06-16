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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prev;
            prev = temp;

        }

        return prev;
    }
    public int pairSum(ListNode head) {
        int max = Integer.MIN_VALUE;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = reverse(slow);
        fast = head;

        while(mid != null){
            int sum = mid.val + fast.val;
            max = Math.max(sum, max);
            mid = mid.next;
            fast = fast.next;
        }

        return max;
    }
}