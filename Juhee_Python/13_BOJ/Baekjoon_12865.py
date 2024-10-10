N, K = map(int, input().split())

L = []
dp = [0 for _ in range(K+1)]

for i in range(N):
    a, b = map(int, input().split())
    L.append([a,b])
    #dp[a] = b
# 무게 순으로 정렬
L.sort(key=lambda x:x[0])


for a, b in L:
    for j in range(K, a-1, -1):
        dp[j] = max(dp[j], dp[j-a]+b)

print(max(dp))