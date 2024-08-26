import sys
input = sys.stdin.readline

N = int(input())

l = list(map(int, input().split()))
l.sort()
a = []
for i in l:
    if i in a:
        pass
    else:
        a.append(i)
print(*a)