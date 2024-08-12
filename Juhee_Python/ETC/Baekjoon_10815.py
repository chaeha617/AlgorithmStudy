import sys
input = sys.stdin.readline

N = int(input())
d = {}

a = list(map(int, input().split()))


M = int(input())
b = list(map(int, input().split()))

for j in b:
    d[j] = 0

for i in a:
    if i in d:
        d[i] += 1

for i in d.values():
    print(i, end=" ")
