
def flatten(N, arr):
    while N > 0:
        mn = min(arr)

        mx = max(arr)

        if mn == mx:
            break

        mxdx = arr.index(mx)
        mndx = arr.index(mn)
        arr[mxdx] -= 1
        arr[mndx] += 1
        N -=1
    a = max(arr) - min(arr)
    return a



T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
    N = int(input())  # 덤프 횟수
    arr = list(map(int, input().split()))
    result = flatten(N, arr)
    print(f"#{test_case} {result}")
