# 시간 초과
# import sys
# input = sys.stdin.readline
# T = int(input())
#
# for i in range(T):
#     idx = 0
#     L = list(input().rstrip())
#     answer = []
#
#     for j in L:
#         if j == '<':
#             if idx > 0:
#                 idx -= 1
#         elif j == '>':
#             if idx < len(answer):
#                 idx += 1
#         elif j == '-':
#             if idx > 0:
#                 idx -= 1
#                 answer.pop(idx)
#         else:
#             answer.insert(idx, j)
#             idx += 1
#     print(''.join(answer))

import sys
from collections import deque
input = sys.stdin.readline
T = int(input())

for i in range(T):
    L = list(input().rstrip())
    left = deque()
    right = deque()

    for j in L:
        if j == "<":
            if left:
                a = left.pop()
                right.appendleft(a)
        elif j == ">":
            if right:
                a = right.popleft()
                left.append(a)
        elif j == "-":
            if left:
                left.pop()
        else:
            left.append(j)
    print(''.join(left + right))