N = int(input())

scvList = list(map(int, input().split()))
attackList = [(3,0),(1,0),(0,1)]
divideThreeList = []
totdivideNine = 0
totdivideThree = 0
totremain = 0

for scv in scvList:
    divideNine = scv // 9
    divideThree = (scv % 9) // 3
    remainThree = scv % 3
    totdivideNine += divideNine
    totdivideThree += divideThree
    totremain += remainThree
    divideThreeList.append((divideNine,divideThree,remainThree))

turn = True
cnt = 0


while turn:
    divideThreeList.sort(reverse=True)
    for divideThreeList