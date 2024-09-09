# 백트래킹으로 풀어보기

N = int(input())
M = list(map(int, input().split()))
# 순서대로 +,-,*,//
add, sub, mul, div = map(int, input().split())


def dfs(n, sm, add, sub, mul, div):
        global mn, mx
        # 종료 조건(정답처리)
        if n == N:
            mn = min(mn, sm)
            mx = max(mx, sm)
            return

        # 연산자 개수 남았을 경우에만 호출
        if add > 0:
            dfs(n + 1, sm + M[n], add - 1, sub, mul, div)
        if sub > 0:
            dfs(n + 1, sm - M[n], add, sub - 1, mul, div)
        if mul > 0:
            dfs(n + 1, sm * M[n], add, sub, mul - 1, div)
        if div > 0:
            dfs(n + 1, int(sm / M[n]), add, sub, mul, div - 1)

mx = int(-1e9)
mn = int(1e9)

dfs(1, M[0], add, sub, mul, div)
print(mx, mn)
