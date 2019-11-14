class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] changes = new int[2];
        for (int bill : bills) {
            if (bill == 5) 
                changes[0]++;
            else if (bill == 10) {
                if (changes[0] < 1)
                    return false;
                else {
                    changes[0]--;
                    changes[1]++;
                }
            }
            else {
                if (changes[1] >= 1 && changes[0] >= 1) {
                    changes[0]--;
                    changes[1]--;
                } else if (changes[0] >= 3)
                    changes[0] -= 3;
                else return false;
            }
        }
        return true;
    }
}
