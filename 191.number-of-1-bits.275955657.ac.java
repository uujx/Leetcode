public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /* Logicl AND
        int count = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) // logical AND: only 1 & 1 == 1
                count++;
            mask <<= 1;
        }
        return count;
        */
        
        
        /* Bit manupulation
        /** n % (n-1) flips the least-significant 1-bit in n to 0
        int count = 0;
        while (n != 0) {
            n &= (n-1);
            count++;
        }
        return count;
        */
        
        
        // Java API
        return Integer.bitCount(n);
    }
}
