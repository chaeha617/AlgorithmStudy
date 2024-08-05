'''
N, M = map(int, input().split())
subjectDic = {x:set() for x in range(1,N+1)}
semester = {x:1 for x in range(1,N+1)}
semesterNotSort = set()

for _ in range(M):
    sub1, sub2 = map(int, input().split())
    subjectDic[sub2].add(sub1)
    semester[sub2] = 0
    semesterNotSort.add(sub2)


semesterCount = 2
while semesterNotSort:
    stack = set()
    for i in range(len(semesterNotSort)):
        sub = list(semesterNotSort)[i]
        subjectDic[sub] = subjectDic[sub] & semesterNotSort
        if subjectDic[sub] == set():
            semester[sub] = semesterCount
            stack.add(sub)
    semesterNotSort = semesterNotSort - stack
    semesterCount += 1


print(' '.join(map(str,semester.values())))
'''

'''
N, M = map(int, input().split())
subjectDic = {x:set() for x in range(1,N+1)}
semester = {x:1 for x in range(1,N+1)}
sortlist = []

for _ in range(M):
    sub1, sub2 = map(int, input().split())
    subjectDic[sub2].add(sub1)
    semester[sub2] = 0
    sortlist.append(sub2)

def calSubject(calsub):
    if subjectDic[calsub] == set():
        semester[calsub] = 1
    else:
        SemeMax = 0
        for sub in subjectDic[calsub]:
            if semester[sub] <= 0:
                calSubject(sub)
                sortlist.remove(sub)
            if SemeMax < semester[sub]:
                SemeMax = semester[sub]
        semester[calsub] = SemeMax + 1


while(sortlist):
    i = sortlist.pop()
    if semester[i] <= 0:
        calSubject(i)

print(' '.join(map(str,semester.values())))
'''

N, M = map(int, input().split())
subjectDic = {x:[] for x in range(1,N+1)}
semester = {x:1 for x in range(1,N+1)}
sortlist = []



while(sortlist):
