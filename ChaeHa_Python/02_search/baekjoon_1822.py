#입력 값에 맞춰 값을 변수, 리스트에 저장
Bn, An = map(int, input().split(" "))
A = list(map(int, input().split(" ")))
B = list(map(int, input().split(" ")))

#이진 탐색을 위해 리스트 정렬
A.sort()
B.sort()

#출력 값 초기화
count = 0
CountList = []

#A 집합을 순회하며 B에 같은 값이 있는지 확인
for AInt in A:
    low = 0
    high = len(B) - 1
    exist = 0

    #같은 값 확인은 이진 탐색으로 진행
    while(high >= low):
        mid = (high + low) // 2
        if B[mid] < AInt:
            low = mid + 1
        elif B[mid] > AInt:
            high = mid -1
        else:
            exist = 1
            break

    # 탐색 결과 확인
    if exist == 0:
        count += 1
        CountList.append(AInt)

#출력형식에 맞춰서 출력
print(count, end="")
if CountList != []:
    print()
    print(CountList.pop(0), end="")
for i in CountList:
    print(" "+str(i), end="")
