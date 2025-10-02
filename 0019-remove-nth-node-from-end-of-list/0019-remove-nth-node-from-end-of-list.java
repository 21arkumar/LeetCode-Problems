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
    int global_n;
    public ListNode removeNode(ListNode node){
        if(node == null){
            global_n--;
            return node;
        }
        ListNode recurrNode = removeNode(node.next);
        if(global_n == 0){
            global_n--;
            return recurrNode;
        }
        node.next = recurrNode;
        global_n--;
        return node;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        global_n = n;
        head = removeNode(node);
        return head;
    }
}