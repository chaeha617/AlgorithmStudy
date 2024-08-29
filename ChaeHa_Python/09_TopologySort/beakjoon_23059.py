import heapq
from collections import defaultdict

itemDic = defaultdict(list)
indegree = defaultdict(int)

N = int(input())

itemQueue = []

for item in indegree:
    if indegree[item] == 0:
        heapq.heappush(itemQueue, item)

itemlist = []

while itemQueue:
    key = heapq.heappop(itemQueue)
    itemlist.append(key)
    for i in sorted(itemDic[key]):
            indegree[i] -= 1
            if indegree[i] == 0:
                heapq.heappush(itemQueue, i)


if len(itemlist) == len(indegree.keys()):
    for item in itemlist:
        print(item)
else:
    print(-1)