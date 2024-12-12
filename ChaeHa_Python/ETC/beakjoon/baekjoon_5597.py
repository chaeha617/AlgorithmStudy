import sys

input = sys.stdin.readline
homework = [True for _ in range(30)]

for __ in range(28):
    idx = int(input())-1
    homework[idx] = False

for ind in range(30):
    if homework[ind]:
        print(ind+1)