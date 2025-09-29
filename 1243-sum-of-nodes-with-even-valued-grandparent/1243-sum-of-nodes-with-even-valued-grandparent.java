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
    public void findPota(TreeNode curr, int depth){
        if(curr == null) return;
        if(depth == 2){
            sum += curr.val;
            return;
        }

        findPota(curr.left, depth + 1);
        findPota(curr.right, depth + 1);
    }
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(curr.val % 2 == 0){
                findPota(curr, 0);
            }

            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
        }   

        return sum;
    }
}