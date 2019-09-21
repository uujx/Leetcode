class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        res = str.strip()
        flag = 1
        if res.startswith('-'):
            flag = -1
            res = res[1:]
        elif res.startswith('+'):
            res = res[1:]
            
        result = 0
        for char in res:
            try:
                result = result * 10 + int(char)
            except ValueError as e:
                if result > 0:
                    break
                else:
                    return 0
        
        if flag < 0 :
            result = -result
            
        if result > 2**31-1:
            result = 2**31 - 1
        elif result < -2**31:
            result = -2**31
        
        return result