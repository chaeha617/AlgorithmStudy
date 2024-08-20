import sys
from collections import deque

input = sys.stdin.readline

n, m = map(int, input().split())
arr2 = list(map(int, input().split()))

arr = deque(range(1, n + 1))
count = 0

for num in arr2:
    while True:
        if arr[0] == num:
            arr.popleft()
            break
        else:
            if arr.index(num) <= len(arr) // 2:
                arr.append(arr.popleft())
            else:
                arr.appendleft(arr.pop())
            count += 1

print(count)
