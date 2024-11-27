N, M = map(int, input().split())
a = []
for i in range(N):
    j = input()
    a.append(j)

count = 0

for i in range(M):
    j = input()
    if j in a:
        count += 1

print(count)