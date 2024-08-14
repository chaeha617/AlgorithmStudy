

answer = 0
itemDic = {}
itemlist = []
itemSet = set()

N = int(input())

for i in range(N):
    a, b = input().split(" ")
    if b in itemDic:
        itemDic[b].add(a)
    else:
        itemDic[b] = set([a])
    itemSet.add(a)
    itemSet.add(b)


itemlist.extend(sorted(list(itemSet - set(itemDic.keys()))))

change = True
while change:
    change = False
    keylist = sorted(list(itemDic.keys()))
    for key in keylist:
        buySet = itemDic[key] - set(itemlist)
        if buySet == set():
            itemlist.append(key)
            del itemDic[key]
            change = True



if len(itemlist) < len(itemSet):
    print(-1)
else:
    for item in itemlist:
        print(item)

