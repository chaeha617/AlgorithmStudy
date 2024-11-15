T = 1
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    t = int(input())
    graph = []

    for i in range(100):
        a = list(map(int, input().split()))
        graph.append(a)

    answer0 = 0
    answer1 = 0
    answer2 = 0
    answer3 = 0

    for i in range(100):
        a = sum(graph[i])
        if a > answer0:
            answer0 = a

    for i in range(100):
        column = [graph[j][i] for j in range(100)]
        a = sum(column)
        if a > answer1:
            answer1 = a

    for i in range(100):
        for j in range(100):
            if i == j:
                answer2 += graph[i][j]
            elif i + j == 100:
                answer3 += graph[i][j]


    print(answer2)

    print(f"#{t} {answer}")