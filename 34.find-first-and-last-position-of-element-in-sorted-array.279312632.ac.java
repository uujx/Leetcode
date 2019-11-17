class Solution {
    public int[] searchRange(int[] nums, int target) {
        /** Two pass - find the left and right boundry respectively
        /*
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) return res;
        
        int l = 0, r = nums.length - 1;
        
        // Search for the left boundry
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (nums[l] != target) return res;
        else res[0] = l;
        
        // Search for the right boundry
        r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2 + 1; // Make the bias to the right
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        res[1] = l;
        
        return res;
        */
        
        
        // Trick - find (target - 0.5) and (target + 0.5)
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) return res;
        
        double left = target - 0.5, right = target + 0.5;
        int l = binarySearch(nums, left);
        int r = binarySearch(nums, right);
        
        if (l != r) {
            res[0] = l;
            res[1] = r - 1;
        }   
        
        return res;
    }
        
        
    private int binarySearch(int[] nums, double target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
