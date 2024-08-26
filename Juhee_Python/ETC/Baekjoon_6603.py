from itertools import combinations
while True:
    N = list(map(int, input().split()))
    a = N[0]
    b = N[1:]

    if a == 0:
        exit()
    else:
        for i in list(combinations(sorted(b), 6)):
            print(*i)

        print()