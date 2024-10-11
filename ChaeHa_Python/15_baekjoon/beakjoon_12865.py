#풀이 1
N, W = map(int, input().split())
objectList = []
weightList = [0 for _ in range(W + 1)]
weightSet = set([0])
for _ in range(N):
    nW, V = map(int, input().split())
    newSet = set()
    newList = weightList.copy()
    for weight in weightSet:
        bagweight = weight + nW

        if bagweight <= W:
            newSet.add(bagweight)
            newList[bagweight] = max(weightList[bagweight], weightList[weight] + V)
    weightSet = weightSet | newSet
    weightList = newList.copy()
print(max(weightList))


# 풀이 2
N, W = map(int, input().split())
weightList = [0 for _ in range(W + 1)]

for _ in range(N):
    nW, V = map(int, input().split())
    for weight in range(W, nW - 1, -1):
        weightList[weight] = max(weightList[weight], weightList[weight - nW] + V)

print(max(weightList))
