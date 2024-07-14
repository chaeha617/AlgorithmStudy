def solution(number, k):
    answer = number
    count = k
    for i in range(k):
      ch = False
      for j in range(len(answer) - 1):
        if answer[j] < answer[j + 1]:
          count -= 1
          answer = answer[:j] + answer[j + 1:]
          ch = True
          break
      if not ch:
        break

    for i in range(count):
      answer = answer.replace(min(answer), '',1)

    return answer