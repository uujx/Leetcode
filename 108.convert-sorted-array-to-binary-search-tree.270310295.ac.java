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
    /** Arrays.copyOfRange slows performance
    /*
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        
        TreeNode root = new TreeNode(nums[nums.length / 2]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length/2 + 1, nums.length));
        
        return root;
    }
    */
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        
        TreeNode root = new TreeNode(nums[nums.length/2]);
        root.left = helper(nums, 0, nums.length/2);
        root.right = helper(nums, nums.length/2+1, nums.length);
        return root;
    }
    
    private TreeNode helper(int[] nums, int low, int high) {
        if (low == high || low > high)
            return null;
        
        TreeNode node = new TreeNode(nums[(high - low) / 2 + low]);
        node.left = helper(nums, low, (high - low) / 2 + low);
        node.right = helper(nums, (high - low) / 2 + low + 1, high);
        return node;
    }
}
