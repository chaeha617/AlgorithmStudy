T = int(input())
for test_case in range(1, T + 1):
    N, M, K = map(int, input().split())
    time = list(map(int, input().split()))
    time.sort()
    result = "Possible"
    for i in range(N):
        amount = (time[i]//M)*K - (i+1)
        if amount < 0:
            result = "Impossible"
            break

    print(f"#{test_case} {result}")
