def playGame(list):
    answer = []
    str = ""

    for i in list:
        if len(i) > 1:
            if "3" in i or "6" in i or "9" in i:
                for j in i:
                    if j == "3" or j == "6" or j == "9":
                        str += "-"
                answer.append(str)
                str = ""
            else:
                answer.append(i)

        else:
            if i == "3" or i == "6" or i == "9":
                answer.append("-")
            else:
                answer.append(i)

    return " ".join(answer)


N = int(input())
list = [str(i) for i in range(1, N + 1)]
result = playGame(list)
print(result)
