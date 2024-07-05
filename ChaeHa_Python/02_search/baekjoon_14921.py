#입력값에 맞춰 변수에 저장
#N = 리스트 길기
#A = 용액 리스트
N = int(input())
A = list(map(int, input().split()))

#용액 혼합값 초기화
mix = A[-1] + A[-2]

#각 용액의 0에 가까운 혼합값을 계산
#자기 자신과 혼합할 수 없기 때문에 전체 길이 -1
for i in range(N-1):
    low = i + 1 #자기자신을 제외
    high = N-1 # 인덱스는 0부터 시작


    #같은 값 확인은 이진 탐색으로 진행
    while high >= low:
        mid = (high + low) // 2
        cal = A[i] + A[mid]
        if cal < 0: #혼합값이 0보다 작음(B의 값을 올려야함
            low = mid + 1
        elif cal > 0: #혼합값이 0보다 큼(B의 값을 내려야함
            high = mid - 1
        else: #혼합값이 0
            mix = 0
            break
        if abs(mix) > abs(cal):
            mix = cal
    if mix == 0: #혼합값이 0이면 더 낮을 수 없기 때문에 반복을 멈춤
        break

#0에 가장 가까운 혼합값을 출력
print(mix,end="")

