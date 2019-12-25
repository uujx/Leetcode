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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int total = 1;
        boolean flag = false;
        
        while (!q.isEmpty()) {
            int count = 0, nextTotal = 0;
            List<Integer> curLevel = new LinkedList<>();
            while (count < total) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    nextTotal++;
                }
                if (node.right != null) {
                    q.add(node.right);
                    nextTotal++;
                }
                
                curLevel.add(node.val);
                count++;
            }
            if (flag) Collections.reverse(curLevel);
            res.add(curLevel);
            flag = !flag;
            total = nextTotal;
        }
        
        return res;
    }
}
