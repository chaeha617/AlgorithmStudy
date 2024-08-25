from collections import deque

answer = 0
itemDic = {}
itemDicPre = {}
itemlist = []
itemSet = set()
N = int(input())

# 입력값을 받아 방향 관련 딕셔너리를 두개 생성하는 코드
for i in range(N):
    a, b = input().split(" ")

    #itemDic은 A를 사서 B를 살수 있게 될수도 있는 목록
    if a in itemDic:
        itemDic[a].add(b)
    else:
        itemDic[a] = set([b])

    #itemDicPre는 B를 사기 위한 A들의 집합
    if b in itemDicPre:
        itemDicPre[b].add(a)
    else:
        itemDicPre[b] = set([a])

    itemSet.add(a)
    itemSet.add(b)


itemlist.extend(sorted(list(itemSet - set(itemDicPre.keys()))))
itemQueue = deque(itemlist)

while itemQueue:
    key = itemQueue.popleft()
    if key in itemDic.keys():
        for i in itemDic[key]:
                itemDicPre[i].remove(key)
                if not itemDicPre[i]:
                    itemlist.append(i)
                    itemQueue.append(i)


if len(itemlist) < len(itemSet):
    print(-1)
else:
    for item in itemlist:
        print(item)

