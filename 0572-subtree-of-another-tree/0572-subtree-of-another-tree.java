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
    void bfsString(TreeNode node, List<String> str){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            StringBuilder temp = new StringBuilder();

            int n = q.size();

            for(int i = 0; i < n; i++){
                TreeNode curr = q.poll();
                if(curr == null){
                    temp.append("null");
                    continue;
                }
                temp.append(curr.val);

                q.add(curr.left);
                q.add(curr.right);
            }

            str.add(temp.toString());
        }
    }    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<String> subStr = new ArrayList<>();
        bfsString(subRoot, subStr);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();

            for(int i = 0; i < n; i++){
                TreeNode curr = q.poll();

                if(curr.val == subRoot.val){
                    List<String> rootStr = new ArrayList<>();

                    bfsString(curr, rootStr);

                    if(rootStr.size() != subStr.size()){
                        if(curr.left != null) q.add(curr.left);
                        if(curr.right != null) q.add(curr.right);
                        continue;
                    }else{
                        int index = rootStr.size();
                        boolean flag = true;
                        for(int _i = 0; _i < index; _i++){
                            if(!rootStr.get(_i).equals(subStr.get(_i))){
                                flag = false;
                                break;
                            }
                        }
                        if(flag) return true;
                    }
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return false;
    }
}