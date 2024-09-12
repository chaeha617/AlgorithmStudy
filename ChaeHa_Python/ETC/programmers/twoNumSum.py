N = int(input())
numli = list(map(int, input().split(" ")))
target = int(input())

numli.sort()

start, end = 0, N-1
count = 0
while start < end:
    tot = numli[start] + numli[end]
    if tot > target:
        end -= 1
    elif tot < target:
        start += 1
    else:
        count += 1
        start += 1

print(count)
