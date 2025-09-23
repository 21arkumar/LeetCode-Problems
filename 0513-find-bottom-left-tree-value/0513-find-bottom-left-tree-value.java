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
    int maxLevel = -1;
    int ans;
    public void helper(TreeNode root, int level){
        if(root == null) return;

        if(level > maxLevel){
            maxLevel = Math.max(level, maxLevel);
            ans = root.val;
        }
        
        if(root.left == null && root.right == null) return;

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
    public int findBottomLeftValue(TreeNode root) {
        //ans = root.val;
        helper(root, 0);
        return ans;
    }
}