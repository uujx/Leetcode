# -*- coding: utf-8 -*-
"""
Created on Wed Dec 12 14:11:34 2018

@author: home
"""

#def generateParenthesis(n):
#    def generate(A = []):
#        if len(A) == 2*n:
#            if valid(A):
#                ans.append("".join(A))
#        else:
#            A.append('(')
#            generate(A)
#            A.pop()
#            A.append(')')
#            generate(A)
#            A.pop()
#
#    def valid(A):
#        bal = 0
#        for c in A:
#            if c == '(': bal += 1
#            else: bal -= 1
#            if bal < 0: return False
#        return bal == 0
#
#    ans = []
#    generate()
#    return ans


def generateParenthesis(N):
    ans = []
    def backtrack(S = '', left = 0, right = 0):
        if len(S) == 2 * N:
            ans.append(S)
            return
        if left < N:
            backtrack(S+'(', left+1, right)
        if right < left:
            backtrack(S+')', left, right+1)

    backtrack()
    return ans

print(generateParenthesis(3))