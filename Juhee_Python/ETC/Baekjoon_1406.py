import sys
from collections import deque
input = sys.stdin.readline

left = deque(input().rstrip())
right = deque()
N = int(input())

for i in range(N):
    a = input().split()
    if len(a) == 2:
        left.append(a[1])
    else:
        if a[0] == "L":
            if left:
                right.appendleft(left.pop())
        elif a[0] == "D":
            if right:
                left.append(right.popleft())
        elif a[0] == "B":
            if left:
                left.pop()

print(''.join(left + right))