class Solution {
    // private class LargerNumberComparator implements Comparator<String> {
    //     @Override
    //     public int compare(String a, String b) {
    //         String order1 = a + b;
    //         String order2 = b + a;
    //         // Why not order1.compareTo(order2)???
    //         return order2.compareTo(order1);
    //     }
    // }
    
    public String largestNumber(int[] nums) {
        String[] strArr = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strArr[i] = String.valueOf(nums[i]);
        
        // Using lambda function slow the runtime from 5ms to 34ms or worse
        // Still don't get why use (s2+s1).compareTo(s1+s2)
        // Alright, if (s1+s2) > (s2+s1), it means s1 > s2, so s1 should be put in front of s2, which means descending order,so it should be (s2+s1).compareTo(s1+s2)
        Arrays.sort(strArr, (s1, s2) -> (s2+s1).compareTo(s1+s2));
        
        if (strArr[0].equals("0"))
            return "0";
        
        String res = new String();
        for (String str : strArr)
            res += str;
        
        return res;
        
    }
}
