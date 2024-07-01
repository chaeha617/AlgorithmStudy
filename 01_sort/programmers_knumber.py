def solution(array, commands):
    answer = []
    for i, j, k in commands:
        ar = sorted(array[i-1:j]) #i부터 j까지 리스트 슬라이싱 및 정렬(얕은 복사)
        answer.append(ar[k-1]) #k번째 수 추출
    return answer

print(solution([1, 5, 2, 6, 3, 7, 4],	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]))