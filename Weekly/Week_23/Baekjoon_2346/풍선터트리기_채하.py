
'''
N = int(input())
papers = list(enumerate(map(int, input().split())))
visited = [False for _ in range(N)]
balloons = []
number = 0

while papers:
    idx, paper = papers[number]
    visited[number] = True
    balloons.append(idx + 1)
    while paper != 0:
        newpaper = paper
        if paper > 0:
            number = number + 1
            newpaper -= 1
        else:
            number = number - 1
            newpaper += 1
        number %= N
        if visited[number]:
            newpaper = paper
        paper = newpaper
print(" ".join(map(str, balloons)))
'''

from collections import deque

N = int(input())
papers = deque(enumerate(map(int, input().split())))
balloons = []
number  = 0
while papers:
    while number != 0 :
        if number < 0:
            number += 1
            papers.appendleft(papers.pop())
        else:
            number -= 1
            papers.append(papers.popleft())
    idx, number = papers.popleft()
    if number > 0:
        number -= 1
    balloons.append(idx + 1)

print(" ".join(map(str,balloons)))
