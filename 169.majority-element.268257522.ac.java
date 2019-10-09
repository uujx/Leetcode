class Solution {
    public int majorityElement(int[] nums) {
        /** Sorting
        Arrays.sort(nums);
        return nums[nums.length / 2];
        */
        
        
        /** HashMap
        /*
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        int max = 0;
        int res = 0;
        for (int num : nums) {
            if (!hashmap.containsKey(num)) {
                hashmap.put(num, 1);
                if (1 > max) {
                    max = 1;
                    res = num;
                } 
            }
            else {
                int now = hashmap.get(num);
                hashmap.put(num, now + 1);
                if (now+1 > max) {
                    max = now + 1;
                    res = num;
                } 
            }
            
        }
        return res;
        */
        
        
        // Randomization
        Random rand = new Random();

        int majorityCount = nums.length/2;

        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount) {
                return candidate;
            }
        }
        
    }
    
    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}
