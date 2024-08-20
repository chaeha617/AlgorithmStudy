import heapq

N = int(input())
if N <= 1:
    print(0)
    exit(0)
dasom = int(input())
vote = 0
voteList = []
for i in range(N-1):
    nVote = int(input())
    heapq.heappush(voteList,(-nVote,nVote))


while True:
    maxVote = heapq.heappop(voteList)[1]

    if maxVote >= dasom:
        dasom += 1
        maxVote -= 1
        heapq.heappush(voteList,(-maxVote,maxVote))
        vote +=1
    else:
        break

print(vote)