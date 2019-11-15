/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /** Intuitive solution
        /*
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (true) {
            // Find the current min value from all the heads
            int min = Integer.MAX_VALUE, index = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
            }
            
            // All the heads are null
            if (min == Integer.MAX_VALUE) break;
            
            // Add it to the res list and move that list to the next
            cur.next = lists[index];
            lists[index] = lists[index].next;
            cur = cur.next;
        }
        return head.next;
        */
        
        
        // Divide and conqur
        // recursively merge two lists at a time
        int interval = 1, N = lists.length;
        while (interval < N) {
            for (int i = 0; i < N; i += 2 * interval) {
                if (i + interval < N)
                    lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return N > 0 ? lists[0] : null;
    }
    
    private ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) return h1 == null ? h2 : h1;
        if (h1.val <= h2.val) {
            h1.next = mergeTwoLists(h1.next, h2);
            return h1;
        } else {
            h2.next = mergeTwoLists(h1, h2.next);
            return h2;
        }
    }
}
