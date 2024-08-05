def solution(program):
    answer = [0]*11
    proTime = 0
    while program:
        program.sort(key= lambda x : (x[1] <= proTime, -x[0], -x[1]),reverse=True)
        pro = program.pop(0)
        answer[pro[0]] += proTime - pro[1]
        proTime += pro[2]
    answer[0] = proTime
    return answer

print(solution([[3, 6, 4], [4, 2, 5], [1, 0, 5], [5, 0, 5]]))
print([19, 0, 0, 4, 3, 14, 0, 0, 0, 0, 0])
print("-------------------------------")


print(solution([[2, 0, 10], [1, 5, 5], [3, 5, 3], [3, 12, 2]]))
print([20, 5, 0, 16, 0, 0, 0, 0, 0, 0, 0])