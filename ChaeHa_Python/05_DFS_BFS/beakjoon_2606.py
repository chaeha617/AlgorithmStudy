computerCnt = int(input())
wormCnt = int(input())

computerNetwork = {x:[] for x in range(1,computerCnt+1)}

for _ in range(wormCnt):
    wormCom, Com = map(int, input().split(" "))
    computerNetwork[wormCom].append(Com)
    computerNetwork[Com].append(wormCom)

stack = [1]
visited = set()

while stack:
    computer = stack.pop(0)
    visited.add(computer)
    for worm in computerNetwork[computer]:
        if worm not in visited:
            stack.append(worm)

print(len(visited)-1)


