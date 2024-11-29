'''
N = int(input())

dp = [[] for _ in range(N)]

dp[0] = [x for x in range(1,10)]

for idx in range(1,N):
    for val in dp[idx-1]:
        lastNum = val % 10
        newNum = val * 10
        if lastNum != 9:
            dp[idx].append(newNum+lastNum + 1)
        if lastNum != 0:
            dp[idx].append(newNum+lastNum-1)

print(len(dp[-1]))
'''

N = int(input())

dp = [[0,0,0,0,0,0,0,0,0,0] for _ in range(N)]

dp[0] = [0,1,1,1,1,1,1,1,1,1]

for idx in range(1,N):
    for val in range(10):
        if val != 9:
            dp[idx][val] += dp[idx-1][val + 1]
        if val != 0:
            dp[idx][val] += dp[idx-1][val - 1]

print(sum(dp[-1]) % 1000000000)