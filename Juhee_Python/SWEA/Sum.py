def inputNum():
    graph = []
    for i in range(100):
        a = list(map(int, input().split()))
        graph.append(a)

    result1 = plus1(graph)
    result2 = plus2(graph)
    return max(result1, result2)

def plus1(graph):
    mx = 0

    for i in range(100):
        n = sum(graph[i])
        if mx < n:
            mx = n

    n2 = 0

    for i in graph:
        n2 += i[0]

    if mx < n2:
        mx = n2
    return mx

def plus2(graph):

    p1 = 0
    for i in range(100):
        p1 += graph[i][i]

    p2 = 0
    for i in range(100):
        p2 += graph[i][99 - i]

    return max(p1,p2)



T = 10
for _ in range(10):
    test_case = int(input())
    answer = inputNum()
    print(f"{test_case} {answer}")