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
    /** First commit
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(s);
        boolean flag = false;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.val == t.val) {
                flag = helper(node.left, t.left) && helper(node.right, t.right);
            }
            if (flag == true) break;
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
        return flag;
    }
    
    private boolean helper(TreeNode s, TreeNode t) {
        if ((s == null && t != null) || (s != null && t == null))
            return false;
        if (s == null && t == null)
            return true;
        if (s != null && t != null) {
            if (s.val == t.val) {
                return helper(s.left, t.left) && helper(s.right, t.right);
            } else {
                return false;
            }
        }
        return false;
    }
    */
    
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)  return false;
        if (isSame(s, t)) return true;
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        
        if (s.val != t.val) return false;
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
    
}
