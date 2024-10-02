def function(N, A):
    answer = {0}
    for i in A:
        new = set()
        for j in answer:
            new.add(i + j)
        answer.update(new)
    return len(answer)

T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    A = list(map(int, input().split()))
    result = function(N, A)
    print(f"#{test_case} {result}")