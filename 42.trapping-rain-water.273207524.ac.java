class Solution {
    public int trap(int[] height) {
        /** DP
        /*
        if (height.length == 0)
            return 0;
        
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        left[0] = height[0];
        for (int i = 1; i < left.length; i++) 
            left[i] = Math.max(left[i-1], height[i]);
        
        right[right.length - 1] = height[height.length - 1];
        for (int i = right.length - 2; i >= 0; i--)
            right[i] = Math.max(right[i+1], height[i]);
        
        int res = 0;
        for (int i = 0; i < height.length; i++)
            res += Math.min(left[i], right[i]) - height[i];
        
        return res;
        */
        
        
        
        /** Stack
        /*
        Stack<Integer> s = new Stack<>();
        int cur = 0, res = 0;
        
        while (cur < height.length) {
            while (!s.isEmpty() && height[cur] > height[s.peek()]) {
                int top = s.pop();
                if (s.isEmpty())
                    break;
                
                int distance = cur - s.peek() - 1;
                int tall = Math.min(height[cur], height[s.peek()]) - height[top];
                res += distance * tall;
            }
            s.push(cur++);
        }
        
        return res;
        */
        
        
        
        // Two Pointers
        if (height.length == 0)
            return 0;
        int leftMax = height[0], rightMax = height[height.length-1];
        int left = 0, right = height.length-1;
        int res = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) 
                    leftMax = height[left++];
                else
                    res += leftMax - height[left++];
                    
            } else {
                if (height[right] > rightMax) 
                    rightMax = height[right--];
                else 
                    res += rightMax - height[right--];
            }
        }
        
        return res;
    }
}
