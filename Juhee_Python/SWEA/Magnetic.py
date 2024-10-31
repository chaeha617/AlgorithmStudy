def magnet(graph):
    count = 0
    for j in range(100):
        found_n = False
        for i in range(100):
            if graph[i][j] == 1:
                found_n = True
            elif graph[i][j] == 2 and found_n:
                count += 1
                found_n = False

    return count


T = 10

for test_case in range(1, T + 1):
    graph = []
    N = int(input())  # 항상 100

    for i in range(100):
        a = list(map(int, input().split()))
        graph.append(a)

    result = magnet(graph)
    print(f"#{test_case} {result}")
