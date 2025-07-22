/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node searchLast(Node head){
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        return curr;
    }
    public Node flatten(Node head) {
        Node curr = head;
        Node temp = null;
        while(curr != null){
            if(curr.child != null){
                temp = searchLast(curr.child);
                temp.next = curr.next;
                if(curr.next != null){
                    curr.next.prev = temp;
                }
                curr.child.prev = curr;
                curr.next = curr.child;
                curr.child = null;
            }

            curr = curr.next;
        }
        return head;
    }
}