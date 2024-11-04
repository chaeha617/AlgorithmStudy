def numberCount(graph):
    a = graph
    b = a[::-1]
    if a == b:
        return 1
    else:
        return 0


T = 10
for test_case in range(1, T + 1):
    count = 0
    N = int(input())
    graph = []
    for i in range(8):
        a = list(input().rstrip())
        graph.append(a)

    # 가로
    for i in range(8):
        b = graph[i]
        for j in range(8 - N + 1):
            c = b[j:j + N]
            count += numberCount(c)

    #세로
    for j in range(8):
        column = [graph[i][j] for i in range(8)]
        for k in range(8 - N + 1):
            c = column[k:k + N]
            count += numberCount(c)

    print(f"#{test_case} {count}")
