import sys
input = sys.stdin.readline
N = int(input())


# 없으면 넣고, 있으면 앞 단어랑 같은지 확인
answer = []
def group(string):
    count = 0
    check = []
    for i in range(len(string)):
        if not check:
            check.append(string[i])
            count += 1
        else:
            if string[i] in check:
                if string[i-1] == string[i]:
                    count += 1
                else:
                    break
            else:
                check.append(string[i])
                count += 1
                
    if count == len(string):
        answer.append(1)

for i in range(N):
    a = input()
    group(a)

print(sum(answer))
