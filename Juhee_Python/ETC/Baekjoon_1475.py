N = list(map(int, input().rstrip()))
dic = {1:0, 2:0, 3:0, 4:0, 5:0, 6:0, 7:0, 8:0, 0:0}

# 6이랑 9는 하나로 세고 개수 세서 가장 많이 필요한 거

for i in N:
    if i == 9:
        dic[6] += 1
    else:
        dic[i] += 1

if dic[6] % 2 == 0:
    dic[6] = dic[6] // 2
else:
    dic[6] = dic[6] // 2 + 1

print(max(dic.values()))