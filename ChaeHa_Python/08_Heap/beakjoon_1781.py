
'''
import heapq

N = int(input())
ramen = 0
workbookHeap = []
workbook = []
time = 0
for i in range(N):
    deadline, noodle = map(int, input().split(" "))
    workbook.append((deadline, noodle))
    if deadline > time:
        time = deadline

for deadline, noodle in workbook:
    heapq.heappush(workbookHeap,(-min(time, deadline), -noodle, deadline))

while workbook and time > 0:
    timeFlag, noodle, deadline = heapq.heappop(workbookHeap)
    if time > deadline:
        time = deadline
    time -= 1
    ramen -= noodle
    workbook = workbookHeap.copy()
    workbookHeap = []
    for _, noodle, deadline in workbook:
        heapq.heappush(workbookHeap, (-min(deadline, time), noodle, deadline))

print(ramen)
'''

'''
N = int(input())
ramen = 0
workbook = []
time = 0
for i in range(N):
    deadline, noodle = map(int, input().split(" "))
    workbook.append((deadline, noodle))
    if deadline > time:
        time = deadline

while workbook and time > 0:
    workbook.sort(key=lambda x: (min(x[0],time), x[1]))
    deadline, noodle = workbook.pop()
    if time > deadline:
        time = deadline
    time -= 1
    ramen += noodle

print(ramen)
'''
import heapq

N = int(input())
ramen = 0
workbook = []

for i in range(N):
    deadline, noodle = map(int, input().split(" "))
    workbook.append((deadline, noodle))

# 마감일을 기준으로 오름차순 정렬
workbook.sort()

max_heap = []

for deadline, noodle in workbook:
    heapq.heappush(max_heap, noodle)  # 라면 수를 최대 힙에 푸시
    if len(max_heap) > deadline:
        heapq.heappop(max_heap)  # 마감일을 초과한 경우, 라면 수가 가장 적은 작업을 제거

# 최대 힙에 남은 요소들(최적의 선택들)을 더함
ramen = sum(max_heap)

print(ramen)