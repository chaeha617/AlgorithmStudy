package Programmers;

import java.util.ArrayList;
import java.util.List;

class 기능개발 {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int day = 0;

        for (int i = 0; i < progresses.length; i++) {
            if (i == 0) {
                int temp = 100 - progresses[i];
                if (temp % speeds[i] == 0) {
                    day += temp / speeds[i];
                } else {
                    day += temp / speeds[i] + 1;
                }
                list.add(1);
            } else {
                int temp = 100 - progresses[i];
                int calculate = 0;
                if (temp % speeds[i] != 0) {
                    calculate = temp / speeds[i] + 1;
                } else {
                    calculate = temp / speeds[i];
                }

                if (calculate <= day) {
                    int t = list.remove(list.size()-1);
                    list.add(t+1);
                } else {
                    day = calculate;
                    list.add(1);
                }
            }

        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}