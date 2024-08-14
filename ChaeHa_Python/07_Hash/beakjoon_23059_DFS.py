from collections import deque

answer = 0
itemDic = {}
itemDicPre = {}
itemlist = []
itemSet = set()
N = int(input())
itemQueue = deque()
for i in range(N):
    a, b = input().split(" ")
    if a in itemDic:
        itemDic[a].add(b)
    else:
        itemDic[a] = set([b])

    if b in itemDicPre:
        itemDicPre[b].add(a)
    else:
        itemDicPre[b] = set([a])

    itemSet.add(a)
    itemSet.add(b)

itemlist.extend(sorted(list(itemSet - set(itemDicPre.keys()))))

for item in itemlist:
    if item in itemDic:
        itemQueue.extend(itemDic[item])


while itemQueue:
    key = itemQueue.popleft()
    if key in itemlist:
        continue
    buySet = itemDicPre[key] - set(itemlist)
    if buySet == set():
        itemlist.append(key)
        if key in itemDic:
            itemQueue.extend(itemDic[key])




if len(itemlist) < len(itemSet):
    print(-1)
else:
    for item in itemlist:
        print(item)

