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
    public void helper(TreeNode root, List<Integer> res, int level){
        if(root == null) return;
        
        if(level > maxLevel){
            res.add(root.val);
            maxLevel = Math.max(level, maxLevel);
        }

        if(root.left == null && root.right == null){
            return;
        }

        helper(root.right, res, level + 1);
        helper(root.left, res, level + 1);

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        helper(root, res, 0);

        return res;
    }
}