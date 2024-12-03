N = int(input())
d = dict()

for i in range(N):
    a = input()
    if a in d:
        d[a] += 1
    else:
        d[a] = 1

d = sorted(d.items(), key=lambda d:(-d[1],d[0]))
print(d[0][0])