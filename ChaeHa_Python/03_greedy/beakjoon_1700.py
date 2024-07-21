N, K = map(int, input().split())

electricList = list(map(int, input().split()))

electricDic = {x : [] for x in set(electricList)}

for idx, i in enumerate(electricList):
    electricDic[i].append(idx)
print(electricDic)

multitap = []
count = 0
for electric in electricList:
    if not electric in multitap:
        if len(multitap) < N:
            multitap.append(electric)
        else:
            maxIdx = -1
            maxElectric = -1
            for idx ,i in enumerate(multitap):
                if electricDic[i] != []:
                    nextIdx = electricDic[i][0]
                    if maxIdx < nextIdx:
                        maxIdx = nextIdx
                        maxElectric = idx
                else:
                    maxElectric = idx
                    break
            multitap.pop(maxElectric)
            count += 1
            multitap.append(electric)
    electricDic[electric].pop(0)

print(count)