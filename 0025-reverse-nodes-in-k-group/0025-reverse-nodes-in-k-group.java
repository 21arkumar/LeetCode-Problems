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
        ListNode temp = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = temp;
            temp = curr;
            curr = next;
        }

        return temp;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode currFirst = head;
        ListNode currLast = head;
        ListNode prev = null;
        while(currFirst != null){
            currLast = currFirst;
            for(int i = 1; i < k; i++){
                currLast = currLast.next;
                if(i < k && currLast == null){
                    return head;
                }
            }
            ListNode temp = currLast.next;
            currLast.next = null;

            ListNode reversedHead = reverse(currFirst);
            if(currFirst == head){
                head = currLast;
            }else{
                prev.next = reversedHead;
            }

            currFirst.next = temp;
            prev = currFirst;
            currFirst = temp;
        }

        return head;

    }
}