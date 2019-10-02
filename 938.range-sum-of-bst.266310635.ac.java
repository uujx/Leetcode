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
    public int rangeSumBST(TreeNode root, int L, int R) {
        return helper(0, root, L, R);
    }
    
    private int helper(int sum, TreeNode root, int L, int R) {
        if (root == null) return sum;
        if (root.val >= L && root.val <= R) {
            sum += root.val + helper(sum, root.left, L, R) + helper(sum, root.right, L, R);
        } else if (root.val < L) {
            sum += helper(sum, root.right, L, R);
        } else if (root.val > R) {
            sum += helper(sum, root.left, L, R);
        } 
        return sum;
    }
}
