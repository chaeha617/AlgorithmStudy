import sys
input = sys.stdin.readline

d = dict()
N, M = map(int, input().split())

for i in range(N):
    a = input().strip()
    if len(a) >= M:
        if a in d:
            d[a] += 1
        else:
            d[a] = 1

sorted_items = sorted(d.items(), key=lambda item: (-item[1], -len(item[0]), item[0]))

sys.stdout.write("\n".join(item[0] for item in sorted_items) + "\n")
