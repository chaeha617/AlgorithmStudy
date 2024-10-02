#https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for test_case in range(1, T + 1):
# ///////////////////////////////////////////////////////////////////////////////////
    field = []
    direction = [(-1,0),(1,0),(0,-1),(0,1)]

    for i in range(4):
        field.append(list(input().split()))

    setList = set()

    for row, rowList in enumerate(field):
        for col, element in enumerate(rowList):
            stack = [(row,col,element)]
            while stack:
                x,y,e = stack.pop()
                if len(e) == 7:
                    setList.add(e)
                else:
                    for dx, dy in direction:
                        nx = x + dx
                        ny = y + dy
                        if nx >= 0 and nx <= 3 and ny >= 0 and ny <= 3:
                            stack.append((nx, ny, e + field[nx][ny]))
    print("#" + str(test_case), str(len(setList)))
# ///////////////////////////////////////////////////////////////////////////////////
