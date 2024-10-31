def countNum(graph, N):  # N이 짝수일 때
    num = []

    for i in graph:
        if not num:
            num.append(i)
        else:
            if i == num[-1]:
                num.pop()
            else:
                num.append(i)

    if N % 2 == 0:
        return 1 if len(num) == 0 else 0

def countNum2(graph, N):
    num = []

    for i in graph:
        if not num:
            num.append(i)
        else:
            if i == num[-1]:
                num.pop()
            if len(num) > 1 and i == num[-2]:
                num.pop(-2)
            else:
                num.append(i)
    if N % 2 == 0:
        return 1 if len(num) == 0 else 0

T = 10
for test_case in range(1, T + 1):
    count = 0
    N = int(input())
    graph = []
    for i in range(8):
        a = list(input().rstrip())
        graph.append(a)

    if N % 2 == 0:
        for i in range(8):
            a = graph[i]
            for k in range(8 - N + 1):
                if countNum(a[k:k + N], N):
                    count += 1

        for j in range(8):
            column = [graph[i][j] for i in range(8)]
            for k in range(8 - N + 1):
                if countNum(column[k:k + N], N):
                    count += 1
    else:
        for i in range(8):
            a = graph[i]
            for k in range(8 - N + 1):
                if countNum2(a[k:k + N], N):
                    count += 1

        for j in range(8):
            column = [graph[i][j] for i in range(8)]
            for k in range(8 - N + 1):
                if countNum2(column[k:k + N], N):
                    count += 1


    print(f"#{test_case} {count}")
