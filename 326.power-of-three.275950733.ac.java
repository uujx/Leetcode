class Solution {
    public boolean isPowerOfThree(int n) {
        // 3 base
        // return Integer.toString(n, 3).matches("^10*$");
        
        // math
        return n > 0 && 1162261467 % n == 0;
    }
}
