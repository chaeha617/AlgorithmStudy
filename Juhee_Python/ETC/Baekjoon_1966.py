T = int(input())

for i in range(T):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))

    printer = []
    for j in range(N):
        printer.append([j, A[j]])

    count = 0
    found = False

    while not found:
        current = printer.pop(0)

        if any(current[1] < other[1] for other in printer):
            printer.append(current)
        else:
            count += 1
            if current[0] == M:
                print(count)
                break

