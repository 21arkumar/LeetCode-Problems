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
//triple class like pair
class Triplet{
    TreeNode node;
    int vertical;
    int level;

    Triplet(TreeNode node, int vertical, int level){
        this.node = node;
        this.vertical = vertical;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Triplet> q = new LinkedList<>();
        q.add(new Triplet(root, 0, 0));

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        
        //BFS
        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                Triplet curr = q.poll();
                TreeNode node = curr.node;
                int vertical = curr.vertical;
                int level = curr.level;

                //put values in one by one
                map.putIfAbsent(vertical, new TreeMap<>());
                map.get(vertical).putIfAbsent(level, new PriorityQueue<>());
                map.get(vertical).get(level).add(node.val);

                if(node.left != null) q.add(new Triplet(node.left, vertical-1, level+1));
                if(node.right != null) q.add(new Triplet(node.right, vertical+1, level+1));
            }
        }
        //forming the ans 2D-list
        for (TreeMap<Integer, PriorityQueue<Integer>> col : map.values()) {
                List<Integer> verticalList = new ArrayList<>();
                for(PriorityQueue<Integer> pq : col.values()){
                    while(!pq.isEmpty()){
                        verticalList.add(pq.poll());
                    }
                }
                ans.add(verticalList);
            }

        return ans;
    }
}