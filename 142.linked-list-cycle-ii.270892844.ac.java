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
    public ListNode detectCycle(ListNode head) {
        /** HashSet
        /*
        HashSet<ListNode> set = new HashSet<>();
        int index = 0;
        while (head != null) {
            if (set.contains(head))
                return head;
            else {
                set.add(head);
                index++;
                head = head.next;
            }
        }
        return null;
        */
        
        // Two Pointers
        // Distance(head -> loop starts) == Distance(meet -> loop starts)
        ListNode slow, fast;
        slow = fast = head;
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode first = head;
                while (first != slow) {
                    first = first.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
    }
}
