import sys
input = sys.stdin.readline


answer = []
for i in range(7):
    a = int(input())
    if a % 2 == 1:
        answer.append(a)

if not answer:
    print(-1)
else:
    print(sum(answer))
    print(min(answer))