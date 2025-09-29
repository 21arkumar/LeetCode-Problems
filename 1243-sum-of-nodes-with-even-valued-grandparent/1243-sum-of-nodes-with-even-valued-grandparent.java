/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    public void findPota(TreeNode curr){
        if(curr == null) return;

        if(curr.val % 2 == 0){
            if(curr.left != null && curr.left.left != null){
                sum += curr.left.left.val;
            }
            if(curr.left != null && curr.left.right != null){
                sum += curr.left.right.val;
            }
            if(curr.right != null && curr.right.left != null){
                sum += curr.right.left.val;
            }
            if(curr.right != null && curr.right.right != null){
                sum += curr.right.right.val;
            }
        }

        findPota(curr.left);
        findPota(curr.right);
    }
    public int sumEvenGrandparent(TreeNode root) {
        findPota(root);

        return sum;
    }
}