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
    int curValue;
    int curCount = 0;
    int maxCount = 0;
    int modeCount = 0;
    int[] modes;
    
    public int[] findMode(TreeNode root) {
        inorder(root);
        modes = new int[modeCount];
        
        curCount = 0;
        modeCount = 0;
        inorder(root);
        
        return modes;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handlingValue(root.val);
        inorder(root.right);
    }
    
    private void handlingValue(int cur) {
        if (cur != curValue) {
            curValue = cur;
            curCount = 0;
        } 
        curCount++;
        if (curCount > maxCount) {
            maxCount = curCount;
            modeCount = 1;
        } else if (curCount == maxCount) {
            if (modes != null) {
                modes[modeCount] = curValue;
            }
            modeCount++;
        }
        
    }
}
