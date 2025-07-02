/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    void dfsSerialize(TreeNode root, StringBuilder str){
        if(root == null){
            str.append("null,");
            return;
        }

        str.append(root.val + ",");

        dfsSerialize(root.left, str);
        dfsSerialize(root.right, str);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder str = new StringBuilder();
        
        dfsSerialize(root, str);
        return str.toString();
    }

    int index = 0;
    TreeNode dfsDeserialize(String[] nodes){
        if(index >= nodes.length || nodes[index].equals("null")){
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));
        root.left = dfsDeserialize(nodes);
        root.right = dfsDeserialize(nodes);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String[] nodes = data.split(",");

        return dfsDeserialize(nodes);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));