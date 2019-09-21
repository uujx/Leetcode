class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
#         res = []
#         for i in range(len(nums) -2):
#             j = i + 1
#             while j < len(nums) -1:
#                 try:
#                     find = nums[j+1:]
#                     k = find.index(-(nums[i] + nums[j]))
#                 except ValueError:
#                     j += 1
#                     continue
                
#                 new = sorted([nums[i], nums[j], find[k]])
#                 if new not in res:    
#                     res.append(new)
#                 j += 1
                
        
#         return res
        
        res = []
        if len(nums) < 3:
            return res
        
        nums = sorted(nums)
        for i in range(len(nums) - 2):
            if i != 0 and nums[i] == nums[i-1]:
                continue
                
            j = i + 1
            k = len(nums) - 1
            while j < k:
                if j != i+1 and nums[j] == nums[j-1]:
                    j += 1
                    continue
                    
                sum = nums[i] + nums[j] + nums[k]
                if sum == 0:
                    res.append([nums[i], nums[j], nums[k]])
                    j += 1
                    k -= 1
                elif sum < 0:
                    j += 1
                else:
                    k -= 1
                    
        return res
    
if __name__ == '__main__':
    l = [-1,0,1,2,-1,-4]
    S = Solution()
    print(S.threeSum(l))