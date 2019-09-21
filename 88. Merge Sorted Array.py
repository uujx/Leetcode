# -*- coding: utf-8 -*-
"""
Created on Thu Dec 20 01:50:00 2018

@author: home
"""

def merge( nums1, m, nums2, n):
    """
    :type nums1: List[int]
    :type m: int
    :type nums2: List[int]
    :type n: int
    :rtype: void Do not return anything, modify nums1 in-place instead.
    """
#    i, j = 0, 0
#    while j < n:
#        if nums1[i] <= nums2[j] and m != 0:
#            i += 1
#            m -= 1
#        else:
#            nums1.insert(i, nums2[j])
#            i += 1
#            j += 1
#    
#    return nums1


    i, j = 0, 0
    while n > 0:
        nums1[m] = nums2[j]
        m += 1
        n -= 1
        j += 1
    
    return sorted(nums1)
    



nums1 = [1,2,3,0,0,0]
nums2 = [2,5,6]
print(merge(nums1, 3, nums2, 3))
        
                
            