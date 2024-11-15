T = int(input())

# 여러 개의 테스트 케이스를 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    graph = [list(input().rstrip()) for _ in range(N)]
    found = False

    for i in range(N):
        for j in range(N - 4):
            if all(graph[i][j + k] == 'o' for k in range(5)):
                print(f"#{test_case} YES")
                found = True
                break
        if found:
            break

        for j in range(N - 4):
            if all(graph[j + k][i] == 'o' for k in range(5)):
                print(f"#{test_case} YES")
                found = True
                break
        if found:
            break

    if not found:
        for i in range(N - 4):
            for j in range(N - 4):
                if all(graph[i + k][j + k] == 'o' for k in range(5)):
                    print(f"#{test_case} YES")
                    found = True
                    break

            if found:
                break

        if not found:
            for i in range(N - 4):
                for j in range(4, N):
                    if all(graph[i + k][j - k] == 'o' for k in range(5)):
                        print(f"#{test_case} YES")
                        found = True
                        break
                if found:
                    break

    if not found:
        print(f"#{test_case} NO")
