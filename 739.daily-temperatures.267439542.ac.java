class Solution {
    public int[] dailyTemperatures(int[] T) {
        /** Stack
        /*
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        
        return res;
        */
        
        // Array
        int[] res = new int[T.length];
        int[] stack = new int[T.length+1];
        int top = -1;
        
        for (int i = 0; i < T.length; i++) {
            while (top > -1 && T[i] > T[stack[top]]) {
                int index = stack[top--];
                res[index] = i - index;
            }
            stack[++top] = i;
        }
        
        return res;
    }
}
