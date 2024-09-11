import sys
input = sys.stdin.readline
B = dict()

N = int(input())
for i in range(N):
    a, b = input().split()
    if b == "enter":
        B[a] = b
    if b == "leave":
        B.pop(a, None)


for name in sorted(B.keys(), reverse=True):
    print(name)