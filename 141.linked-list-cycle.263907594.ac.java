/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        /* Cheat Solution
        
        while(head != null) {
            if (head.val != Integer.MAX_VALUE)
                head.val = Integer.MAX_VALUE;
            else 
                return true;
            
            head = head.next;
        }
        
        return false;
        */
        
        
        /* The one with the HashTable
        /
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.contains(head)) 
                set.add(head);
            else
                return true;
            
            head = head.next;
        }
        
        return false;
        */
        
        
        
        // The one with TWO pointers
        if (head == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
} 
