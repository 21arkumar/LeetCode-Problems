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
    public boolean traversal(TreeNode root, int targetSum, int sum){
        if(root == null) return false;
        int currSum = sum+root.val;
        System.out.println(currSum);
        if(currSum == targetSum && root.left == null && root.right == null) return true;
        return traversal(root.left, targetSum, currSum) || traversal(root.right, targetSum, currSum);
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(targetSum == root.val && root.left == null && root.right == null) return true;


        return traversal(root.left, targetSum, root.val) || traversal(root.right, targetSum, root.val);
    }
}