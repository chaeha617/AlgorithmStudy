import sys
input = sys.stdin.readline

A = int(input())
B = int(input())
C = int(input())

num = A * B * C

# 딕셔너리 사용

a = dict()
for i in range(10):
    a[i] = 0

for j in str(num):
    a[int(j)] += 1

for i, j in a.items():
    print(j)