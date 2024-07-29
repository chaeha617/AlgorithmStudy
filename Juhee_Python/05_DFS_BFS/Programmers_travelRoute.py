def solution(tickets):
    a = len(tickets)
    visited = [0] * a

    tickets.sort(key=lambda x: (x[0], x[1]))
    answer = []
    b = []

    def dfs(airport, path):
        answer.append(path)
        if len(path) == a+1:
            b.append(path)
        for i, (j,k) in enumerate(tickets):
            if j == airport and visited[i] == 0:
                visited[i] = 1
                dfs(k, path+[k])
                visited[i] = 0


#다 넣어보고 개수가 맞으면? 맨 앞에 걸 넣어야되나


    dfs("ICN", ["ICN"])

    return b[0]







print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
#["ICN", "JFK", "HND", "IAD"]

print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))
#["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"]

print(solution([["ICN", "BBB"], ["BBB", "ICN"], ["ICN", "AAA"]]))
#["ICN", "BBB", "ICN", "AAA"]