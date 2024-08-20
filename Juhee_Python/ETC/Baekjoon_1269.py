import sys
input = sys.stdin.readline

# 이렇게 복잡하게 풀었는데 이게 되네...?

A, B = map(int, input().split())

a = dict()
b = dict()

a1 = list(map(int, input().split()))
b1 = list(map(int, input().split()))

for i in a1:
    a[i] = 0

for j in b1:
    b[j] = 0

for i in a1:
    if i in b:
        b[i] += 1

for j in b1:
    if j in a:
        a[j] += 1

count = 0
for k, l in b.items():
    if l == 0:
        count += 1

for j, k in a.items():
    if k == 0:
        count += 1

print(count)