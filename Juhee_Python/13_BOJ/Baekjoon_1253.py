import sys
input = sys.stdin.readline

N = int(input())
a = list(map(int, input().split()))
a.sort()

count = 0

for k in range(N):
    target = a[k]
    start = 0
    end = N-1

    while start < end:
        if start == k:
            start += 1
            continue
        if end == k:
            end -= 1
            continue

        num = a[start] + a[end]

        if num == target:
            count += 1
            break
        if num < target:
            start += 1
        else:
            end -= 1

print(count)