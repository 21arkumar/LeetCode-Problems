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

class Tuple{
    int sum = 0;
    //if the current root doesnot form a BST
    boolean flag = false;
    //will help in checking the BST condition
    int lMax = Integer.MIN_VALUE;
    int rMin = Integer.MAX_VALUE;

    Tuple(){

    }

    Tuple(int a, int b, int c, boolean d){
        lMax = a;
        rMin = b;
        sum = c;
        flag = d;
    }
}

class Solution {
    int ans = 0;

    Tuple helper(TreeNode root){
        if(root == null) return new Tuple(Integer.MIN_VALUE, Integer.MAX_VALUE, 0, true);

        Tuple left = helper(root.left);
        Tuple right = helper(root.right);

        if(left.flag == true && right.flag == true && root.val > left.lMax && root.val < right.rMin){
            int currSum = root.val + left.sum + right.sum;
            ans = Math.max(ans, currSum);

            return new Tuple(Math.max(root.val, right.lMax), Math.min(root.val, left.rMin), currSum, true);
        }

        return new Tuple();
    }

    public int maxSumBST(TreeNode root) {
        // helper(root);
        ans = 0;
        helper(root);
        return ans;
    }
}