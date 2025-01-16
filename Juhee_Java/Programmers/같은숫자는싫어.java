package Programmers;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        for (int a : arr) {
            if (list.isEmpty()) {
                list.add(a);
            } else {
                if (a != list.get(list.size()-1)) {
                    list.add(a);
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}