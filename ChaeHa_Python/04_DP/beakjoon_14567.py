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

N, M = map(int, input().split())
semester = {x:1 for x in range(1,N+1)}
subjectDic = {}
for _ in range(M):
    sub1, sub2 = map(int, input().split())
    
    subjectDic[sub1].add(sub2)
    semester[sub2] = 0

print(semester)
print(subjectDic)
print(' '.join(map(str,semester.values())))