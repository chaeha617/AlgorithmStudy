N, C = map(int, input().split())
A = list(map(int, input().split()))
d = dict()

for i in A:
    if i in d:
        d[i] += 1
    else:
        d[i] = 1

d = sorted(d.items(), key=lambda d:d[1], reverse=True)

answer = []
for i in d:
    for j in range(i[1]):
        answer.append(i[0])

print(*answer)