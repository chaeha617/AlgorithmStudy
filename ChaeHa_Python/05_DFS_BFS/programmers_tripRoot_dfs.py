import copy
def solution(tickets):
    tripSet = set()
    for st, en in tickets:
        tripSet.add(st)
        tripSet.add(en)

    tripdic = {x : [] for x in tripSet}

    for starttrip, endtrip in tickets:
        if starttrip not in tripdic.keys():
            tripdic[starttrip] = [endtrip]
        else:
            tripdic[starttrip].append(endtrip)
# 입력값을 이용하여 딕셔너리에 넣음

    stackDic = [tripdic.copy()]
    stack = [["ICN"]]

    while stack:
        nowRoot = stack.pop()
        now = nowRoot[-1]
        dic = stackDic.pop()
        if len(dic[now]) > 0:
            for i in sorted(dic[now],reverse=True):
                useDic = copy.deepcopy(dic)
                stack.append(nowRoot + [i])
                useDic[now].remove(i)
                stackDic.append(useDic)
        else:
            if len(nowRoot) >= len(tickets):
                return nowRoot



#print(solution([["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]))
print(solution([["ICN", "SFO"], ["ICN", "ATL"], ["SFO", "ATL"], ["ATL", "ICN"], ["ATL","SFO"]]))
print(solution([["ICN", "D"], ["D", "ICN"], ["ICN", "B"]]))