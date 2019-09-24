/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private ListNode res;
    
    public ListNode reverseList(ListNode head) {
        // Use a stack to save all the node values
        
//         if (head == null)
//             return head;
        
//         Stack<Integer> stack = new Stack<>();
//         while (head != null) {
//             stack.push(head.val);
//             head = head.next;
//         }
        
//         head = new ListNode(stack.pop());
//         ListNode next = head;
//         while (!stack.empty()) {
//             next.next = new ListNode(stack.pop());
//             next = next.next;
//         }
        
//         return head;
        
        
        // 1. Save the current node and the next node
        // 2. Reverse the current point
        // 3. Go to the next node
//         if (head == null)
//             return head;
            
//         ListNode prev = null;
//         ListNode next;
//         while (head.next != null) {
//             next = head.next;
//             head.next = prev;
//             prev = head;
//             head = next;
//         }
//         head.next = prev;
        
//         return head;
        
        
        
        // Recursive solution
        if (head == null) return head;
        
        ListNode prev = null;
        helper(head, prev);
        return res;
        
    }
    
    private void helper(ListNode head, ListNode prev) {
        if (head.next != null)
            helper(head.next, head);
        else 
            res = head;
        head.next = prev;
    }
}
