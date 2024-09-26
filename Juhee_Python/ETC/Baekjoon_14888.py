N = int(input()) # 수의 개수
A = list(map(int, input().split())) # 수
add, sub, mul, div = map(int, input().split()) # +,-,*,/ 개수

mx = -int(1e9)
mn = int(1e9)

def function(n, sum, add, sub, mul, div):
    global mx, mn

    if n == N:
        mx = max(mx, sum)
        mn = min(mn, sum)
        return mx, mn

    if add > 0:
        function(n+1, sum + A[n], add-1, sub, mul, div)
    if sub > 0:
        function(n+1, sum - A[n], add, sub-1, mul, div)
    if mul > 0:
        function(n+1, sum * A[n], add, sub, mul-1, div)
    if div > 0:
        function(n+1, int(sum/A[n]), add, sub, mul, div-1)

function(1, A[0], add, sub, mul, div)
print(mx)
print(mn)