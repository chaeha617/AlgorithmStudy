def generate(li, visited, depth, M, combination):
    if depth == M:
        visited.add(tuple(combination))
        return

    for num in li:
        if num not in combination:
            combination.append(num)
            generate(li, visited, depth+1, M, combination)
            combination.pop()

N, M = map(int, input().split())
li = [i for i in range(1, N+1)]
visited = set()

generate(li, visited, 0, M, [])

for comb in sorted(visited):
    print(*comb)
