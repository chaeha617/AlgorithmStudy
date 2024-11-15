T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    graph = []

    for i in range(N):
        a = list(map(int, input().split()))
        graph.append(a)


    mx = 0

    for i in range(N-M+1):
        for j in range(N-M+1):
            count = 0
            for k in range(M):
                for m in range(M):
                    count += graph[i+k][j+m]
            if count > mx:
                mx = count

    print(f"#{test_case} {mx}")


