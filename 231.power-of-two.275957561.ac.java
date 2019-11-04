class Solution {
    public boolean isPowerOfTwo(int n) {
        // base 2: all the power of two in binary is starting with 1 followed by 0
        // return Integer.toString(n, 2).matches("^10*$");
        
        // n & (n-1) flips the least-significant 1-bit in n to 0
        // if n is power of two, then it would be like "1000...000" with only one 1
        // return n > 0 && (n & (n-1)) == 0;
        
        // math
        return n > 0 && (1073741824 % n == 0);
    }
}
