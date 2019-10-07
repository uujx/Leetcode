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
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
        } else {
            sb.append(Integer.toString(node.val)).append(",");
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(data.split(",")));
        return buildTree(list);
    }

    private TreeNode buildTree(LinkedList<String> list) {
        String str = list.poll();
        if (str.equals("null"))
            return null;
        
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = buildTree(list);
        node.right = buildTree(list);
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
