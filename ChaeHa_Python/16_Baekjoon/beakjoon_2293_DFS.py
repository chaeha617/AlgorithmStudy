n, k = map(int, input().split())

coinlist = []
dplist = [set() for _ in range(k+1)]

for _ in range(n):
    coinlist.append(int(input()))
