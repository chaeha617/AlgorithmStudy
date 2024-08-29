T = int(input())
intList = []
dp = [0,1,2,4]
for _ in range(T):
    intList.append(int(input()))

for i in range(3,max(intList)+1):
    dp.append(dp[i]+dp[i-1]+dp[i-2])

for answer in intList:
    print(dp[answer])