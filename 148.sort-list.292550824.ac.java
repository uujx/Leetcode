/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        /** Merge sort - Top down method
        if (head == null || head.next == null) return head;
        
        // 1. find the mid node - (head -> prev) and (slow -> end)
        ListNode prev = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        // 2. reversively sort each part
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        
        // 3. merge two sorted lists
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        
        if (l1 != null) p.next = l1;
        else p.next = l2;

        return l.next; 
    }
    */
        
        // Merge sort - bottom up method
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // get the list length
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        
        for (int sz = 1; sz < len; sz <<= 1) {
            ListNode cur = dummy.next, prev = dummy;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, sz);
                cur = split(right, sz);
                prev = merge(left, right, prev);
            }
        }
        
        return dummy.next;
    }
    
    // split the list, return the head node of the right half
    private ListNode split(ListNode head, int sz) {
        if (head == null) return null;
        
        for (int i = 1; i < sz && head.next != null; i++) {
            head = head.next;
        }
        ListNode right = head.next;
        head.next = null;
        
        return right;
    }
        
    // merge two list together, concatenate to the node prev, return the new prev
    private ListNode merge(ListNode l1, ListNode l2, ListNode prev) {
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        if (l1 != null) prev.next = l1;
        else prev.next = l2;
        
        while (prev.next != null) prev = prev.next;
        
        return prev;
    }
}
