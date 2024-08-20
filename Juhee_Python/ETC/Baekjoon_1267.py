import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))

# 영식 요금 계산
Y = 0
for i in A:
    Y += (i // 30 + 1) * 10

# 민식 요금 계산
M = 0
for i in A:
    M += (i // 60 + 1) * 15

if Y < M:
    print("Y", Y)
elif M < Y:
    print("M", M)
else:
    print("Y M", Y)
