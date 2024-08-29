'''
N, M = map(int, input().split())
subject = {x : set() for x in range(1,N+1)}
subjectReverse = {x : set() for x in range(1,N+1)}
semester = {x : 1 for x in range(1,N+1)}
semesterNotSort = set()

for _ in range(M):
    sub1, sub2 = map(int, input().split())
    subject[sub2].add(sub1)
    subjectReverse[sub1].add(sub2)

    semesterNotSort.add(sub2)

semesterQueue = list(set(semester.keys()) - semesterNotSort)

while semesterQueue:
    sub = semesterQueue.pop(0)
    for i in subjectReverse[sub]:
        subject[i].remove(sub)
        semester[i]= max(semester[i],semester[sub]+1)
        if not subject[i]:
            semesterQueue.append(i)

print(' '.join(map(str,semester.values())))
'''

from collections import deque

N, M = map(int, input().split())
subject = {x : set() for x in range(1,N+1)}
subjectReverse = {x : set() for x in range(1,N+1)}
semester = {x : 1 for x in range(1,N+1)}
indgree = {x : 0 for x in range(1, N+1)}
semesterNotSort = set()

for _ in range(M):
    sub1, sub2 = map(int, input().split())
    subject[sub2].add(sub1)
    subjectReverse[sub1].add(sub2)
    semesterNotSort.add(sub2)
    indgree[sub2] += 1

semesterQueue = deque()
for key, val in indgree.items():
    if val <= 0:
        semesterQueue.append(key)


while semesterQueue:
    sub = semesterQueue.popleft()
    for i in subjectReverse[sub]:
        indgree[i] -= 1
        semester[i]= max(semester[i],semester[sub]+1)
        if indgree[i] <= 0:
            semesterQueue.append(i)

print(' '.join(map(str,semester.values())))

