class Solution {
    public int findKthLargest(int[] nums, int k) {
        /** Heap
        /* PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for (int num : nums) {
            if (pq.size() < k) 
                pq.add(num);
            else if (num > pq.peek()){
                pq.poll();
                pq.add(num);
            }
        }
        
        return pq.peek();
        */
        
        
    // Quickselect
        shuffle(nums);
        k = nums.length - k;
        return quickSelect(nums, 0, nums.length-1, k);
    }
    
    private int quickSelect(int[] nums, int lo, int hi, int k) {
        if (lo >= hi) return nums[lo];
        
        int pivot = partition(nums, lo, hi);
        if      (pivot > k) return quickSelect(nums, lo, pivot-1, k); 
        else if (pivot < k) return quickSelect(nums, pivot+1, hi, k);
        else                return nums[pivot];
        
    }
    
    private int partition(int[] a, int lo, int hi) {
        int i = lo, j = hi+1;
        int pivotValue = a[lo];
        while (true) {
            while (i < hi && a[++i] <= pivotValue);
            while (j > lo && a[--j] > pivotValue);
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    
    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 1; i < nums.length; i++) {
            int r = random.nextInt(i+1);
            exch(nums, i, r);
        }
    }
}
