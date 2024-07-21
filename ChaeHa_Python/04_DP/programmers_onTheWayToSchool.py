def solution(m, n, puddles):
    answer = 0
    routeList = [[0 for _ in range(m)] for _ in range(n)]

    for x, y in puddles:
        routeList[y - 1][x - 1] = -1

    routeList[0][0] = 1

    for i in range(n):
        for j in range(m):
            route = routeList[i][j]
            if route <= -1 or i + j == 0:
                continue
            if i <= 0:
                pass
            else:
                route += max(0, routeList[i - 1][j])
            if j <= 0:
                pass
            else:
                route += max(0, routeList[i][j - 1])
            routeList[i][j] = route

    return (routeList[n - 1][m - 1] % 1000000007)

'''
                # 테스트 케이스 7: 지도 크기가 2x2인 경우, 물웅덩이 없음
                (2, 2, [], 2),
        
                # 테스트 케이스 8: 지도 크기가 2x2인 경우, 물웅덩이 하나
                (2, 2, [[2, 1]], 1),
        
                # 테스트 케이스 9: 물웅덩이가 여러개 있는 경우
                (3, 3, [[2, 2], [3, 2]], 2),
        
                # 테스트 케이스 10: 물웅덩이가 없을 때 최대 크기
                (100, 100, [], 690285631),
        
                # 테스트 케이스 11: 물웅덩이가 여러개 있는 경우
                (5, 5, [[2, 2], [2, 3], [3, 2], [3, 3]], 14),
        
                # 테스트 케이스 12: 지도 크기가 5x5인 경우, 물웅덩이가 가로막고 있을 때
                (5, 5, [[2, 2], [3, 3], [4, 4]], 27),
        
                # 테스트 케이스 13: 긴 직사각형 지도, 물웅덩이 없음
                (10, 2, [], 10),
'''
test_cases = [
        # 테스트 케이스 14: 긴 직사각형 지도, 물웅덩이 하나
        #(10, 2, [[5, 1]], 5),

        # 테스트 케이스 15: 물웅덩이가 목적지 근처에 있는 경우
        (4, 4, [[3, 4]], 7),

        # 테스트 케이스 16: 물웅덩이가 출발지 근처에 있는 경우
        (4, 4, [[1, 2]], 0),

        # 테스트 케이스 17: 모든 경로가 물웅덩이로 막혀있는 경우
        (3, 3, [[1, 2], [2, 1]], 0)
    ]


def test_solution():

    for i, (m, n, puddles, expected) in enumerate(test_cases, 1):
        result = solution(m, n, puddles)
        print(m, n, puddles, expected, result)


test_solution()
