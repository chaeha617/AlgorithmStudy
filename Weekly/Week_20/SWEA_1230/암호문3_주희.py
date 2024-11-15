def solutionI(password, num, part):
    for i in range(len(part)):
        password.insert(num+i, part[i])
    return password

def solutionD(password, num, num2):
    for i in range(num2):
        password.remove(password[num+1])
    return password

def solutionA(password, num, part):
    password.append(part)
    return password

T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())
    password = list(map(int, input().split()))
    M = int(input())
    action = input().split()

    for i in range(M):
        if action[0] == "I":
            num = int(action[1])
            l = int(action[2])
            part = action[3:3+l]
            solutionI(password, num, part)
            action = action[3+l:]
        elif action[0] == "D":
            num = int(action[1])
            num2 = int(action[2])
            solutionD(password, num, num2)
            action = action[3:]
        elif action[0] == "A":
            num = int(action[1])
            part = action[2:2+num]
            solutionA(password, num, part)
            action = action[2+num:]
    answer = password[:10]
    print(f"#{test_case} {' '.join(answer)}")
