# -*- coding: utf-8 -*-
"""
Created on Sat Dec  1 22:43:15 2018

@author: home
"""
def solution(nums, target):
    nums = sorted(nums)
        res = 0
        tiny = None
        if len(nums) < 3:
            return tiny

        for i in range(len(nums)-2):
            if i == 0 or nums[i] != nums[i-1]:
                j = i + 1
                k = len(nums) - 1
                while j < k:
                    if j != i+1 and nums[j] == nums[j-1]:
                        j += 1
                        continue
                        
                    total = nums[i] + nums[j] + nums[k]
                    temp = abs(target - total)
                    if tiny == None:
                        tiny = temp
                        res = total
                    elif temp < tiny:
                        tiny = temp
                        res = total

                    if total < target:
                        j += 1
                    elif total > target:
                        k -= 1
                    else:
                        j += 1
                        k -= 1
                    
        return res


if __name__ == '__main__':
    nums = [0, 2, 1, -3]
    target = 1
    print(solution(nums, target))
    
    
    
    
    
    
    