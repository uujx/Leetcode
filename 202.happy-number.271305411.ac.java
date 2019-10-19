class Solution {
    public boolean isHappy(int n) {
        if (n <= 0)
            return false;
        
        HashSet<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int newSum = 0;
            while (n != 0) {
                int remain = n % 10;
                newSum += Math.pow(remain, 2);
                n /= 10;
            }
            if (newSum == 1)
                return true;
            else 
                n = newSum;
        }
        return false;
    }
}
