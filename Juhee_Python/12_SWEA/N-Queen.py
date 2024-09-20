count = 0
def nqueen(V):
    global count
    if V == N:
        count += 1
        return
    else:
        for x in range(N):
            if function(V, x):
                graph[V] = x
                nqueen(V + 1)

def function(row, col):
    for i in range(row):
        if graph[i] == col or abs(graph[i]-col) == row - i:
            return False
    return True


T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    graph = [0] * N
    count = 0
    nqueen(0)
    print( f"#{test_case} {count}")