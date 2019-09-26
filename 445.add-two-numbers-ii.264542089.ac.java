/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    /** Reversing lists 
    /*
    private ListNode reverse(ListNode l) {
        ListNode prev = null;
        while (l.next != null) {
            ListNode next = l.next;
            l.next = prev;
            prev = l;
            l = next;
        }
        l.next = prev;
        return l;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        boolean flag = false;
        ListNode res = null, prev = null;
        int sum = 0;
        while (l1 != null || l2 != null || flag) {
            if (l1 != null && l2 != null)
                sum = flag ? l1.val + l2.val + 1 : l1.val + l2.val;
            else if (l1 == null && l2 != null)
                sum = flag ? l2.val + 1 : l2.val;
            else if (l2 == null && l1 != null)
                sum = flag ? l1.val + 1 : l1.val;
            else {
                sum = 1;
                flag = false;
            }
            
            if (sum >= 10) {
                flag = true;
                sum = sum % 10;
            } else {
                flag = false;
            }
            
            
            ListNode node = new ListNode(sum);
            if (res == null) {
                res = node;
                prev = node;
            } else {
                prev.next = node;
                prev = node;
            }
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return reverse(res);
    }
    */
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode node = new ListNode(0);
        int sum = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            
            node.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = node;
            node = head;
            sum /= 10;
        }
        
        return node.val == 0 ? node.next : node;
        
    }
}
