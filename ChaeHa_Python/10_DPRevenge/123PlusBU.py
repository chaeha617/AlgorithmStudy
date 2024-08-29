T = int(input())
intList = []
dp = [0,1,2,4]
for _ in range(T):
    intList.append(int(input()))

for _ in range(3,max(intList)+1):
    dp.append(-1)

def plus123(n):
    if dp[n] == -1:
        dp[n] = plus123(n-1) + plus123(n-2) + plus123(n-3)
    return dp[n]

plus123(max(intList))

for answer in intList:
    print(dp[answer])