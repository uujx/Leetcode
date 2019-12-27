class Solution {
    public int findPeakElement(int[] nums) {
        /** Recursive binary search
        return search(nums, 0, nums.length-1);    
    }
    
    private int search(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] < nums[mid + 1])
            return search(nums, mid + 1, hi);
        else
            return search(nums, lo, mid);
    }
    */
        
        
        // Iterative
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1])
                lo = mid + 1;
            else 
                hi = mid;
        }
        return lo;
    }
}
