import itertools

def rotate(graph, r, c, s):
    r, c = r - 1, c - 1
    graph_copy = [row[:] for row in graph]

    start_row, start_col = r - s, c - s
    end_row, end_col = r + s, c + s

    for layer in range(s):
        top, left = start_row + layer, start_col + layer
        bottom, right = end_row - layer, end_col - layer

        temp = graph_copy[top][right]

        for col in range(right, left, -1):
            graph_copy[top][col] = graph_copy[top][col - 1]

        for row in range(top, bottom):
            graph_copy[row][left] = graph_copy[row + 1][left]

        for col in range(left, right):
            graph_copy[bottom][col] = graph_copy[bottom][col + 1]

        for row in range(bottom, top, -1):
            graph_copy[row][right] = graph_copy[row - 1][right]

        graph_copy[top + 1][right] = temp

    return graph_copy

def calculate_value(graph):
    return min(sum(row) for row in graph)


def solution(N, M, K, graph, operations):
    min_value = 10000000000

    # 순열 생성
    for perm in itertools.permutations(operations):
        rotated_graph = graph
        for r, c, s in perm:
            rotated_graph = rotate(rotated_graph, r, c, s)

        min_value = min(min_value, calculate_value(rotated_graph))

    return min_value


N, M, K = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
operations = [tuple(map(int, input().split())) for _ in range(K)]

print(solution(N, M, K, graph, operations))
