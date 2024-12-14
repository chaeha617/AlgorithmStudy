import math
N = int(input())

size = list(map(int, input().split()))
T, P = map(int, input().split())
tSet = 0

for tSize in size:
    tSet += math.ceil(tSize / T)

pSet = N // P

print(tSet)
print(pSet, N % P)