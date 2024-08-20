A, B = map(int, input().split())

if A > B:
    A, B = B, A

if A + 1 < B:
    answer = list(range(A + 1, B))
else:
    answer = []

print(len(answer))

if answer:
    print(" ".join(map(str, answer)))
