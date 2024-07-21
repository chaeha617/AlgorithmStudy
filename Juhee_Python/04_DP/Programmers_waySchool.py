def solution(m, n, puddles):
    dp = [[0 for _ in range(m)] for _ in range(n)] # 각 지점 경로 수 저장
    dp[0][0] = 1 # 초기값 설정

    for p in puddles: # 물에 잠긴 지역 표시
        a, b = p
        dp[b-1][a-1] = -1

    for i in range(n):
        for j in range(m):
            # 현재 위치가 물웅덩이거나 초기값이 아닌 경우에는 건너뜀
            if dp[i][j] == 0:
                if i-1 == -1 or (i-1 >= 0 and dp[i-1][j] == -1):
                    #위가 벽이거나 물웅덩이인 경우
                    if j-1 == -1 or (j-1 >= 0 and dp[i][j-1] == -1):
                        continue
                    else:
                        dp[i][j] = dp[i][j-1]
                elif j-1 == -1 or (j-1 >= 0 and dp[i][j-1] == -1):
                    # 왼쪽이 벽이거나 웅덩이인 경우
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i][j-1] + dp[i-1][j]

    return dp[-1][-1] % 1000000007



print(solution(4, 3, [[2, 2]]))