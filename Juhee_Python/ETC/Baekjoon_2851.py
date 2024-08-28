import sys
input = sys.stdin.readline
l = []
for i in range(10):
    l.append(int(input()))


score = 0
for i in l:
    score += i
    if score >= 100:
        if score - 100 > 100 - (score - i):
            score -= i
        break
print(score)