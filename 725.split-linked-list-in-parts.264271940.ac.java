/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int sz = 0;
        for (ListNode l = root; l != null; l = l.next, sz++) {}
        int partSize = sz / k, rem = sz % k;
        
        ListNode[] parts = new ListNode[k];
        
        ListNode node = root, prev = null;
        for (int i = 0; node != null && i < k; i++, rem--) {
            parts[i] = node;
            for (int j = 0; j < partSize + (rem > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return parts;       
    }
}
