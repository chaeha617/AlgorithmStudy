package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class 가장큰수 {
    public static String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for (int n : numbers) {
            list.add(String.valueOf(n));
        }

        Collections.sort(list, (a, b) -> {
            return (b + a).compareTo(a + b);
        });


        StringBuilder answer = new StringBuilder();

        for (String n : list) {
            answer.append(n);
        }


        if (list.get(0).equals("0")) {
            return "0";
        }

        return answer.toString();
    }

    public static void main(String args[]) {
        int[] input = {3, 30, 34, 5, 9};
        String s = solution(input);
        System.out.println(s);
    }
}
