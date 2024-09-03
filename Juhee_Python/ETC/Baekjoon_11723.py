import sys
input = sys.stdin.readline
M = int(input())
S = set()
A = {i for i in range(1, 21)}

for i in range(M):
    a = input().split()
    if a[0] == "add":
        S.add(int(a[1]))
    elif a[0] == "remove":
        S.discard(int(a[1]))
    elif a[0] == "check":
        if int(a[1]) in S:
            print(1)
        else:
            print(0)
    elif a[0] == "toggle":
        num = int(a[1])
        if num in S:
            S.remove(num)
        else:
            S.add(num)
    elif a[0] == "all":
        S = A.copy()
    elif a[0] == "empty":
        S.clear()
