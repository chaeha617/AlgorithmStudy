import sys
input = sys.stdin.readline

N, M = map(int, input().split())
L = list(map(int, input().split()))
perfix_sum = [0]

temp = 0
for i in L:
    temp += i
    perfix_sum.append(temp)

for i in range(M):
    a, b = map(int, input().split())
    print(perfix_sum[b] - perfix_sum[a-1])