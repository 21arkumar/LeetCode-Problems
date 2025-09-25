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
    boolean dfs(TreeNode root){
        if(root == null) return false;
        // if(root.left == null && root.right == null && root.val != 1) return false;

        if(!dfs(root.left)){
            root.left = null;
        }

        if(!dfs(root.right)){
            root.right = null;
        }
        
        if(root.left == null && root.right == null && root.val != 1) return false;

        return true;
    }
    public TreeNode pruneTree(TreeNode root) {
        if(!dfs(root)){
            return null;
        }else{
            return root;
        }

    }
}