# -*- coding: utf-8 -*-
"""
Created on Fri Dec 14 00:12:28 2018

@author: home
"""

def intToRoman(num):
    """
    :type num: int
    :rtype: str
    """
    
    def oneDigit(num, s = ''):
        if num == 0:
            res.append(s)
            return
        
        if num >= 1000:
            times = num // 1000
            s = oneDigit(num % 1000, s + 'M' * times)
#            return s
        elif num >= 900:
            
            s = oneDigit(num - 900, s + 'CM')
#            return s
        elif num >= 500:
            
            s = oneDigit(num - 500, s + 'D')
#            return s
        elif num >= 400:
            
            s = oneDigit(num - 400, s + 'CD')
#            return s
        elif num >= 100:
            times = num // 100
            
            s = oneDigit(num % 100, s + 'C' * times)
#            return s
        elif num >= 90:
            
            s = oneDigit(num - 90, s + 'XC')
#            return s
        elif num >= 50:
            
            s = oneDigit(num - 50, s + 'L')
#            return s
        elif num >= 40:
            
            s = oneDigit(num - 40, s + 'XL')
#            return s
        elif num >= 10:
            times = num // 10
            
            s = oneDigit(num % 10, s + 'X' * times)
#            return s
        elif num >= 9:
            
            s = oneDigit(num - 9, s + 'IX')
#            return s
        elif num >= 5:
            
            s = oneDigit(num - 5, s + 'V')
#            return s
        elif num >= 4:
            
            s = oneDigit(num - 4, s + 'IV')
#            return s
        elif num >= 1:
            times = num // 1
            
            s = oneDigit(num % 1, s + 'I' * times)
#            return s
    
    res = []
    oneDigit(num)
    return res[0]


print(intToRoman(3))
            