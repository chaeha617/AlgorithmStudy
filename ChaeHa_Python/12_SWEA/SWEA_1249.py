T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    fd = []
    dp = []
    for _ in range(N):
        fd.append(list(map(int, list(input()))))
        dp.append([-1 for i in range(N)])
    dp[0][0] = 0
    for x in range(N):
        for y in range(N):
            numLi = []
            if x + y == 0:
                continue
            if x - 1 > -1:
                numLi.append(dp[x-1][y])
            if y - 1 > -1:
                numLi.append(dp[x][y-1])
            dp[x][y] = min(numLi) + fd[x][y]
    print("#"+str(test_case),dp[-1][-1])