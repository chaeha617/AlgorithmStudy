import sys
from collections import deque
input = sys.stdin.readline
S = int(input())

A = deque()

for i in range(1, S+1):
    A.append(i)

while len(A) != 1:
    A.popleft()
    b = A.popleft()
    A.append(b)

print(A[0])