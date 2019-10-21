class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++)
                    primes[i*j] = true;
            }
        }
        
        return count;
    }
    
}
