n = int(input())

paper = [[0] * 100 for _ in range(100)]
total = 100 * n

for i in range(n):
    a, b = map(int, input().split())

    for j in range(a, a+10):
        for k in range(b, b+10):
            paper[j][k] = 1

total = 0
for l in range(100):
    total += paper[l].count(1)
print(total)