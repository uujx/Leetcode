/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        /** Inorder traverse - 5ms
        /*
        List<Integer> seq = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        boolean done = false;
        while (!done) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                if (s.size() > 0) {
                    cur = s.pop();
                    seq.add(cur.val);
                    cur = cur.right;
                } else done = true;
            }
        }
        
        return seq.get(k-1);
        */
        
        
        // Inorder traverse optimization - 1ms
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
