n, k = map(int, input().split())

coinlist = []
dplist = [set() for _ in range(k+1)]

for _ in range(n):
    coinlist.append(int(input()))

dic = {x:0 for x in coinlist}
dplist[0].add(dic)

for i in range(1,k+1):
    numSet = set()
    for coin in coinlist:
        if i >= coin:
            for coinDict in dplist[i - coin]:
                coinDict[coin] += 1
    dplist[i] = numSet

print(len(dplist[k]))
