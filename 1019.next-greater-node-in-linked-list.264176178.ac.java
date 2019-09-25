/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        /** Brute Force
        /*
        
        int count = 0;
        LinkedList<Integer> store = new LinkedList<>();
        int nextGreaterValue;
        int curValue;
        ListNode findPointer;
        
        while (head != null) {
            findPointer = head.next;
            curValue = head.val;
            
            while(findPointer != null)
                if (findPointer.val > curValue)
                    break;
                else
                    findPointer = findPointer.next;
            nextGreaterValue = findPointer == null ? 0 : findPointer.val;
            store.add(nextGreaterValue);
            
            head = head.next;
            count++;
        }
        
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = store.pop();
        }
        
        return res;
        */
        
        
        /** The one with a stack **/
        class Wrapper {
            int val;
            int pos;
            Wrapper(int value, int position) {
                val = value;
                pos = position;
            }
        }
        
        int sz = 0;
        for (ListNode l = head; l != null; l = l.next, sz++) {}
        int[] res = new int[sz];
        
        int i = 0;
        Stack<Wrapper> stack = new Stack<>();
        for (ListNode l = head; l != null; l = l.next, i++) {
            int curValue = l.val;
            while (!stack.isEmpty() && curValue > stack.peek().val) 
                res[stack.pop().pos] = curValue;
            
            stack.push(new Wrapper(curValue, i));
        }
        
        while (!stack.isEmpty()) 
            res[stack.pop().pos] = 0;
        
        return res;
        
    }
}
