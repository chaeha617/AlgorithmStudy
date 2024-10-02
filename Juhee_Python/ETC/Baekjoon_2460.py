import sys
input = sys.stdin.readline

p = 0
answer = 0

for i in range(10):
    a, b = list(map(int, input().split()))
    p = p - a + b
    if p > answer:
        answer = p

print(answer)