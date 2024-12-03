import heapq

N = int(input("작업 개수 입력: "))
tasks = []
for _ in range(N):
    name, priority, time = input("작업 정보 입력: ").split()
    priority, time = int(priority), int(time)
    heapq.heappush(tasks, (-priority, time, name))

print("\n작업 처리 순서:")
while tasks:
    priority, time, name = heapq.heappop(tasks)
    print(f"작업명: {name}, 우선순위: {-priority}, 처리 시간: {time}")

