

answer = 0
itemDic = {}
itemlist = []
itemSet = set()

N = int(input())

for i in range(N):
    a, b = input().split(" ")
    if b in itemDic:
        itemDic[b].add(b)
    else:
        itemDic[b] = set([b])
    itemSet.update([a,b])


itemlist.extend(sorted(list(itemSet - set(itemDic.keys()))))
change = True
while change:
    change = False
    for key in itemDic.keys():




if len(itemlist) < len(itemSet):
    print(-1)
else:
    for item in itemlist:
        print(item)

