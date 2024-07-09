N = int(input())
A = list(map(int, input().split()))

m = A[0] + A[1] # 초기 용액 값 설정

for i in range(N-1):
    high = N-1
    low = i + 1 # 자기 자신 제외
    while high >= low: # 이분 탐색 시작
        mid = (high + low) // 2
        a = A[i] + A[mid] # 기준 용액 + 중간 용액 값
        if a == 0: # 0이면 종료
            m = a
            break
        else:
            if a < 0: # 0보다 작으면 오른쪽으로
                low = mid + 1
            elif a > 0: # 0보다 크면 왼쪽으로
                high = mid - 1
            else:
                a = 0 # 값이 0이면 종료
                break
            if abs(a) < abs(m): # 0과 가까운지 비교하여 값 업데이트
                m = a

print(m)