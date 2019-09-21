# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        # if head.next == None:
        #     return None

        # dommy = ListNode(0)
        # dommy.next = head
        # first = head
        # count = 0

        # while first != None:
        #     count += 1
        #     first = first.next
        
        # tar = count - n
        # first = head

        # while tar > 0:
        #     tar -= 1
        #     first = first.next
        
        # first.next = first.next.next

        # return dommy.next

        