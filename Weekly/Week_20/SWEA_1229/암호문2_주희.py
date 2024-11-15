def solution_I(n, a):
    n1 = int(n[0])
    n2 = n[1]
    n3 = n[2:]
    for i in range(len(n3)):
        a.insert(n1, n3[i])
        n1 += 1

    return a

def solution_D(n, a):
    n1 = int(n[0])
    n2 = int(n[1])

    for i in range(n2):
        del a[n1]
    return a

T = 10
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input()) # 원본 암호문의 길이
    a = list(input().split())
    M = int(input())
    action = input().split()

    for i in range(M):

        if action[0] == "I":
            num = int(action[2])
            n = action[1:2+num+1]
            solution_I(n, a)
            action = action[2+num+1:]
        elif action[0] == "D":
            n = action[1:3]
            solution_D(n, a)
            action = action[3:]

    a = a[:10]

    print(f"#{test_case} {' '.join(a)}")