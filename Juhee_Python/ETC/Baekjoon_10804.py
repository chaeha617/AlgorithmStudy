arr = [i for i in range(1, 21)]

for i in range(10):
    a, b = map(int, input().split())
    store = arr[a-1:b]
    store.reverse()
    arr[a-1:b] = store

print(*arr)