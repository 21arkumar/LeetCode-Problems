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
    void dfs(TreeNode root, List<Integer> in){
        if(root == null) return;
        dfs(root.left, in);
        in.add(root.val);
        dfs(root.right, in);
    }
    public boolean isValidBST(TreeNode root){
        List<Integer> in = new ArrayList<>();
        dfs(root, in);
        for(int i = 1; i < in.size(); i++){
            if(in.get(i) <= in.get(i-1)) return false;
        }
        return true;
    }
}