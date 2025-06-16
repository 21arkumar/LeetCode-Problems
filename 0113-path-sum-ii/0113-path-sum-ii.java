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
    void dfs(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> temp){
        if(root == null) return;
        targetSum -= root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null && targetSum == 0){
            ans.add(new ArrayList<>(temp));
        }else{
            dfs(root.left, targetSum, ans, temp);
            dfs(root.right, targetSum, ans, temp); 
        }
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, targetSum, ans, temp);
        return ans;
    }
}