import sys
input = sys.stdin.readline
N, K = map(int, input().split())

temp = 0
arr = []

a = list(map(int, input().split()))

for i in a:
    temp += i
    arr.append(temp)

# 앞부터 시작해서 빼기 2개 앞을

m = arr[K-1]
for j in range(K, N):
    value = arr[j] - arr[j-K]
    if value > m:
        m = value

print(m)