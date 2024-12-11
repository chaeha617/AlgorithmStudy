def operationTime(time, change):
    time[1] += change
    if time[1] < 0:
        time[0] -= 1
        time[1] = 60 + time[1]
    if time[1] > 59:
        time[0] += 1
        time[1] %= 60
    return time

def compareTime(time1, time2):
    if time1[0] > time2[0]:
        return 1
    elif time1[0] < time2[0]:
        return -1
    else:
        if time1[1] > time2[1]:
            return 1
        elif time1[1] < time2[1]:
            return -1
        else:
            return 0


def solution(video_len, pos, op_start, op_end, commands):
    video_len = list(map(int, video_len.split(":")))
    pos = list(map(int, pos.split(":")))
    op_start = list(map(int, op_start.split(":")))
    op_end = list(map(int, op_end.split(":")))

    video_start = [0,0]

    if compareTime(pos, op_start) >= 0 >= compareTime(pos, op_end):
        pos = op_end.copy()

    for command in commands:
        if command == "prev":
            pos = operationTime(pos, -10)
        if command == "next":
            pos = operationTime(pos, 10)

        if compareTime(pos, video_start) < 0:
            pos = video_start.copy()
        if compareTime(pos, video_len) > 0:
            pos = video_len.copy()

        if compareTime(pos, op_start) >= 0 >= compareTime(pos, op_end):
            pos = op_end.copy()


    return "{0:02d}:{1:02d}".format(pos[0],pos[1])


print(solution("34:33","13:00","00:55","02:55",["next","prev"]))

print(solution("10:00", "00:03", "00:00", "00:05", ["prev", "next"]))

print(solution("10:00", "10:00", "01:00", "02:00", ["next", "prev"]))
