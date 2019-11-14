class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /** My solution
        int start = 0;
        boolean[] tried = new boolean[gas.length];
        while (true) {
            int tank = 0, now = start;
            boolean flag = false;
            for (int i = 0; i < gas.length; i++) {
                tank += gas[now];
                if (tank >= cost[now]){
                    flag = true;
                    tank -= cost[now];
                    now = (now + 1) % gas.length;
                } else break;
            }
            if (flag && now == start) return start;
            else {
                tried[start] = true;
                start = (now + 1) % gas.length;
                if (tried[start]) return -1;
            }
        }
        */
        
        
        // 1. if starting from a and finally reach b, then ignore nodes between a and b
        // 2. if total gas > total cost, there must be an answer
        int start = 0, total = 0, tank = 0;
        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                total += tank;
                tank = 0;
            }
        }
        return total + tank < 0 ? -1 : start;
    }
}
