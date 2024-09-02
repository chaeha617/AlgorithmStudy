N = int(input())
intLi = list(map(int,input().split(" ")))

dp = [{intLi[0]:1}]

for idx in range(1,N-1):
    dic = {}
    for number, cnt in dp[idx-1].items():
        if number + intLi[idx] < 21:
            if number + intLi[idx] in dic:
                dic[number + intLi[idx]] += cnt
            else:
                dic[number + intLi[idx]] = cnt

        if number - intLi[idx] > -1:
            if number - intLi[idx] in dic:
                dic[number - intLi[idx]] += cnt
            else:
                dic[number - intLi[idx]] = cnt
    dp.append(dic)

if intLi[-1] in dp[-1]:
    print(dp[-1][intLi[-1]])
else:
    print(0)