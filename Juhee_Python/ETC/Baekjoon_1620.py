import sys

input = sys.stdin.readline

N, M = map(int, input().split())

name_to_index = {}
index_to_name = {}

for i in range(1, N + 1):
    a = input().strip()
    name_to_index[a] = i
    index_to_name[i] = a

for _ in range(M):
    b = input().strip()

    try:
        b = int(b)
        print(index_to_name.get(b))
    except ValueError:
        print(name_to_index.get(b))
