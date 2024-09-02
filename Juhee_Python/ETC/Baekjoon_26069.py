N = int(input())
dance = set()
for i in range(N):
    a, b = input().split()
    if a == "ChongChong":
        dance.add(b)
    elif b == "ChongChong":
        dance.add(a)

    if dance and a in dance:
        dance.add(b)
    elif dance and b in dance:
        dance.add(a)

print(len(dance))