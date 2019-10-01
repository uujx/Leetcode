import java.util.Hashtable;

class Solution {
    public int singleNumber(int[] nums) {
//         Hashtable<Integer, Integer> table = new Hashtable<>();
//         for (int i = 0; i < nums.length; i++) {
//             if (table.containsKey(nums[i])) 
//                 table.remove(nums[i]);
//             else 
//                 table.put(nums[i], 1);
//         }
        
//         return table.keys().nextElement();
        
        int a = 0;
        for (int num : nums) 
            a ^= num;
        return a;
    }
}
