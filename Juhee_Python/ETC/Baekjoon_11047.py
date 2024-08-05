N, K = map(int, input().split())
A = []

for i in range(N):
    a = int(input())
    A.append(a)

A.sort(reverse=True)

count = 0
for i in A:
    if K == 0:
        break
    else:
        b = K // i
        count += b
        K = K % i

print(count)