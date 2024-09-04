import sys
from itertools import permutations
from collections import deque

input = sys.stdin.readline
N = int(input())
A = list(map(int, input().split()))
# 순서대로 +, -, *, //
B = list(map(int, input().split()))

# 연산자 리스트 생성
operators = []
operator_symbols = ["+", "-", "*", "//"]

for i in range(4):
    for j in range(B[i]):
        operators.append(operator_symbols[i])

# 가능한 모든 연산자 순열을 생성
l = list(permutations(operators, len(operators)))
queue = deque(l)

answer = []

ma = -1
mi = 1

while queue:
    n = queue.pop()
    now = A[0]
    for i in range(1, N):
        if n[i-1] == "+":
            now += A[i]
        elif n[i-1] == "-":
            now -= A[i]
        elif n[i-1] == "*":
            now *= A[i]
        elif n[i-1] == "//":
            if now < 0:
                now = -(abs(now) // A[i])
            else:
                now //= A[i]
    ma = max(ma, now)
    mi = min(mi, now)

print(ma)
print(mi)
