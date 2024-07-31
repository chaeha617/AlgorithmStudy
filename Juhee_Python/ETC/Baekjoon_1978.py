N = int(input())

A = list(map(int, input().split()))

count = 0

for i in A:
    a = 0
    for j in range(1, i):
        if i % j == 0:
            a += 1
    if a == 1:
        count += 1

print(count)
