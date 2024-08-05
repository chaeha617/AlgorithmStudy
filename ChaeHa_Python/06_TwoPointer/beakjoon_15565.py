N, K = map(int, input().split(" "))
dolllist = list(map(int, input().split(" ")))
dollqueue = []
minlion = len(dolllist) + 1


for idx, doll in enumerate(dolllist):
    if doll == 1:
        dollqueue.append(idx)
        if len(dollqueue) >= K:
            minlion = min(minlion, dollqueue[-1] - dollqueue[-K] + 1)
if minlion > len(dolllist):
    print(-1)
else:
    print(minlion)