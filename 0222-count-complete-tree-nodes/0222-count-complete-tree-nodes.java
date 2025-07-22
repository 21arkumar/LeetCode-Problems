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
    public int depthCalc(TreeNode node){
        int depth = 0;
        while(node != null){
            depth++;
            node = node.left;
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = depthCalc(root.left);
        int rightDepth = depthCalc(root.right);   

        if(leftDepth == rightDepth){
            return (1 << leftDepth) + countNodes(root.right);
        }else{
            return (1 << rightDepth) + countNodes(root.left);
        }
    }
}