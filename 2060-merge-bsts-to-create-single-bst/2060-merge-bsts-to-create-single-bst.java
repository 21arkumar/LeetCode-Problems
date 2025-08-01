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
    // boolean isValidBSTFinal(TreeNode root, Integer min, Integer max) {
    //     if (root == null) return true;
    //     if ((min != null && root.val <= min) || (max != null && root.val >= max)) return false;
    //     return isValidBSTFinal(root.left, min, root.val) && isValidBSTFinal(root.right, root.val, max);
    // }
    void dfs(TreeNode root, List<Integer> in){
        if(root == null) return;
        dfs(root.left, in);
        in.add(root.val);
        dfs(root.right, in);
    }
    boolean isValidBST(TreeNode root){
        List<Integer> in = new ArrayList<>();
        dfs(root, in);
        for(int i = 1; i < in.size(); i++){
            if(in.get(i) <= in.get(i-1)) return false;
        }
        return true;
    }
    void collectAllNodes(TreeNode node, Map<Integer, TreeNode> map){
        if(node == null) return;
        map.put(node.val, node);
        collectAllNodes(node.left, map);
        collectAllNodes(node.right, map);
    }

    void buildTree(TreeNode parent, Map<Integer, TreeNode> roots){
        if(parent.left != null && roots.containsKey(parent.left.val)){
            parent.left = roots.get(parent.left.val);
            roots.remove(parent.left.val);
            buildTree(parent.left, roots);
        }
        if(parent.right != null && roots.containsKey(parent.right.val)){
            parent.right = roots.get(parent.right.val);
            roots.remove(parent.right.val);
            buildTree(parent.right, roots);
        }
    }

    public TreeNode canMerge(List<TreeNode> trees) {
        int n = trees.size();
        if(n == 1) return trees.get(0);

        Map<Integer, TreeNode> map = new HashMap<>();
        //map is storing lead valuf as key and its own node as value
        for(TreeNode node : trees){
            collectAllNodes(node.left, map);
            collectAllNodes(node.right, map);
        }

        //finding multiple parents of merged bst
        TreeNode parent = null;
        Map<Integer, TreeNode> roots = new HashMap<>();        
        for(int i = 0; i < n; i++){
            int val = trees.get(i).val;
            roots.put(val, trees.get(i));
            //multiple ultimate parents means no solution
            if (!map.containsKey(val)) {
                if(parent != null){
                    return null;
                }
                parent = trees.get(i);
            }
        }
        //still if parent is null we return null
        if(parent == null) return null;
        buildTree(parent, roots);
        //if all the trees are merged or not
        if(roots.size() > 1) return null;
        //validity of bst
        return isValidBST(parent)  ? parent : null;
    }
}