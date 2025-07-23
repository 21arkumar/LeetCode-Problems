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
    int index;
    public TreeNode build(int[] postorder, Map<Integer, Integer> map, int start, int end){
        if(start > end) return null;

        TreeNode node = new TreeNode(postorder[index--]);
        int mid = map.get(node.val);

        node.right = build(postorder, map, mid+1, end);
        node.left = build(postorder, map, start, mid-1);

        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        index = n - 1;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }

        TreeNode root = build(postorder, map, 0, n-1);
        return root;
    }
}