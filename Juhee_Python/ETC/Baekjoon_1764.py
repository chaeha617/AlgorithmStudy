import sys
input = sys.stdin.readline

N, M = map(int, input().split())

d = {}
for i in range(N+M):
    a = input().rstrip()
    if a not in d:
        d[a] = 1
    else:
        d[a] += 1

answer = []

for i, j in d.items():
    if j > 1:
        answer.append(i)

b = len(answer)
answer.sort()
print(b)
for i in range(b):
    print(answer[i])