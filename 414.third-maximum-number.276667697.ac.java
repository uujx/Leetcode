class Solution {
    public int thirdMax(int[] nums) {
        // 1. Sort - O(nlogn)
        
        // 2. Heap
        if (nums.length == 1) return nums[0];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(3);
        for (int num : nums) {
            if (!pq.contains(num)) {
                if (pq.size() < 3)
                    pq.add(num);
                else if (num > pq.peek()) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        if (pq.size() == 3 || pq.size() == 1) // size = 1 for [1,1,1]
            return pq.peek();
        else { // for size = 2
            pq.poll();
            return pq.peek();
        }
        
        
        /** 3. Three Pointers
        /* max1, max2, max3
        /* if num == max1/2/3, continue
        /* num > max1        -> max3 = max2, max2 = max1, max1 = num
        /* max1 > num > max2 -> max3 = max2, max2 = num
        /* max2 > num > max3 -> max3 = num
        */

    }
}
