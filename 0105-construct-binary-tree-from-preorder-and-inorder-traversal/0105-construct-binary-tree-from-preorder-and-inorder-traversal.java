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
    int index = 0;
    public TreeNode build(int[] preorder, Map<Integer, Integer> map, int start, int end){
        if(start > end) return null;

        TreeNode node = new TreeNode(preorder[index++]);

        int mid = map.get(node.val);

        node.left = build(preorder, map, start, mid-1);
        node.right = build(preorder, map, mid+1, end);

        return node;



    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mp.put(inorder[i], i);
        }

        TreeNode root = build(preorder, mp, 0, n-1);
        return root;
    }
}