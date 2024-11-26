def solution(progresses, speeds):
    answer = []
    for i in range(len(progresses)):
        a = 100 - progresses[i]
        if a % speeds[i] == 0:
            b = a // speeds[i]
        else:
            b = a // speeds[i] + 1
        answer.append(b)

    result = []
    current_max = answer[0]
    count = 1

    for j in range(1, len(answer)):
        if answer[j] <= current_max:
            count += 1
        else:
            result.append(count)
            count = 1
            current_max = answer[j]

    result.append(count)
    print(result)

    return result

solution([93, 30, 55], [1, 30, 5])