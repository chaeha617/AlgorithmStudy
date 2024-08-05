def solution(queries):
    answer = []
    rrlist = ["RR","Rr","Rr","rr"]
    dp = [["Rr"],["RR","Rr","Rr","rr"]]
    maxGen = sorted(queries,key=lambda x:x[0],reverse=True)[0][0]
    for i in range(2,maxGen):
        stack = []
        for j in dp[i-1]:
            if j == "RR":
                stack +=["RR"] * 4
            elif j == "rr":
                stack += ["rr"] * 4
            else:
                stack += rrlist
        dp.append(stack)

    for gn, idx in queries:
        answer.append(dp[gn-1][idx-1])
    print(dp)
    return answer

print(solution([[4,5]]))