def solution(graph):

    answer = []

    for i in range(len(graph)+1, 1, -1):
        original = graph[:i]
        s = original[::-1]
        if original == s:
            answer.append(len(original))
        else:
            answer.append(0)

    return max(answer)

T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    mx = 0

    test = int(input())
    graph = []

    graph2 = []

    for i in range(100):
        a = list(input().rstrip())
        for j in range(1, 100):
            result = solution(a[j:])
            if result > mx:
                mx = result
        graph.append(a)

    for j in range(100):
        column = [graph[i][j] for i in range(100)]
        for k in range(1, 100):
            result = solution(column[k:])
            if result > mx:
                mx = result
        graph2.append(column)

    print(f"#{test} {mx}")