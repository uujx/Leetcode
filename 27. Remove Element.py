# -*- coding: utf-8 -*-
"""
Created on Tue Dec  4 15:10:32 2018

@author: home
"""

#         while val in nums:
#             nums.remove(val)
#         res = len(nums)
    
#         return res


#def solution(nums, val):
#    nums = list(filter(lambda x: x != val, nums))
#    res = len(nums)
#    
#    return res


def solution(nums, val):
    nums = [e for e in nums if e != val]
    print(nums)
    res = len(nums)
    
    return res

    
if __name__ == "__main__":
    nums = [3, 2, 2, 3]
    val = 3
    i = 0
    while i < solution(nums, val):
        print(nums[i])
        i += 1
    