S = list(map(int, input().rstrip()))

a = []
for i in S:
    if not a:
        a.append(i)
    else:
        if i == a[-1]:
            continue
        else:
            a.append(i)

a1 = a.count(0)
a2 = a.count(1)

print(min(a1, a2))