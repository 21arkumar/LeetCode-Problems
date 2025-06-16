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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        int group = 1;

        while (curr != null) {
            int count = 0;
            ListNode temp = curr;

            // Count actual nodes in the current group
            while (temp != null && count < group) {
                temp = temp.next;
                count++;
            }

            // Save the start and end of the group
            ListNode groupStart = curr;
            ListNode groupEnd = temp;

            // Move curr forward for next group iteration
            for (int i = 0; i < count; i++) {
                curr = curr.next;
            }

            if (count % 2 == 0) {
                // Reverse the group of size `count`
                ListNode prevNode = groupEnd;
                ListNode currentNode = groupStart;

                for (int i = 0; i < count; i++) {
                    ListNode nextNode = currentNode.next;
                    currentNode.next = prevNode;
                    prevNode = currentNode;
                    currentNode = nextNode;
                }

                prev.next = prevNode; // Link with previous group
                prev = groupStart;    // Update prev to end of current group
            } else {
                // If not reversed, just move prev
                for (int i = 0; i < count; i++) {
                    prev = prev.next;
                }
            }

            group++;
        }

        return dummy.next;
    }
}
